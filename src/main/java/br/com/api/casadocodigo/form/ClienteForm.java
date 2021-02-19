package br.com.api.casadocodigo.form;

import br.com.api.casadocodigo.Validador.CpfCnpj;
import br.com.api.casadocodigo.Validador.ExistsId;
import br.com.api.casadocodigo.Validador.UniqueValue;
import br.com.api.casadocodigo.modelo.Cliente;
import br.com.api.casadocodigo.modelo.Estado;
import br.com.api.casadocodigo.modelo.Pais;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteForm{
@Email
@NotBlank
@UniqueValue(domainClass = Cliente.class, fieldName = "email")
private String email;

@NotBlank
private String nome;

@NotBlank
private String sobrenome;

@NotBlank
@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
@CpfCnpj
private String documento;

@NotBlank
private String endereco;

@NotBlank
private String complemento;

@NotNull
private String cidade;

private Long idEstado;

@NotNull
private Long idPais;

@NotBlank
private String telefone;

@NotBlank
private String cep;

public ClienteForm(@Email @NotBlank String email,
@NotBlank String nome,
@NotBlank String sobrenome,
@NotBlank String documento,
@NotBlank String endereco,
@NotBlank String complemento,
@NotNull String cidade,
@NotNull Long idEstado,
@NotNull Long idPais,
@NotBlank String telefone,
@NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento.replaceAll("[^\\d]", "");;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idEstado = idEstado;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
        }

@Override
public String toString() {
        return "ClienteRequest{" +
        "email='" + email + '\'' +
        ", nome='" + nome + '\'' +
        ", sobrenome='" + sobrenome + '\'' +
        ", documento='" + documento + '\'' +
        ", endereco='" + endereco + '\'' +
        ", cidade=" + cidade +
        ", idEstado=" + idEstado +
        ", idPais=" + idPais +
        ", telefone='" + telefone + '\'' +
        ", cep='" + cep + '\'' +
        '}';
        }

public Cliente converter(EntityManager manager) {
@NotNull Pais pais = manager.find(Pais.class, this.idPais);
        Estado estado = null;
        if(this.idEstado != null){
        estado = manager.find(Estado.class, this.idEstado);
        }

        return new Cliente (nome, sobrenome, email, documento,  endereco, complemento, cidade, pais, estado, telefone, cep);
        }


public Long getIdEstado() {
        return idEstado;
        }

public Long getIdPais() {
        return idPais;
        }

public boolean estadoTaNoPais(List<Estado> estadosPais) {
        for (Estado estado : estadosPais) {
        if(estado.getId() == this.getIdEstado()) {
        return true;
        }
        }

        return false;
        }
        }