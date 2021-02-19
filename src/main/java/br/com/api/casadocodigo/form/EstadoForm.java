package br.com.api.casadocodigo.form;


import br.com.api.casadocodigo.Validador.ExistsId;
import br.com.api.casadocodigo.Validador.UniqueValues;
import br.com.api.casadocodigo.modelo.Estado;
import br.com.api.casadocodigo.modelo.Pais;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueValues(domainClass = Estado.class, fields = {"nome", "idPais"}, aliases = {"nome", "pais.id"}, message = "Estado já cadastro nesse Pais")
public class EstadoForm {
    @NotBlank
    private String nome;

    @ExistsId(domainClass = Pais.class, fieldName = "id")
    @NotNull
    private Long idPais;

    public EstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converter(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, this.idPais);

        Assert.state(pais!= null, "Você está tentando cadastrar em um pais que não existe no nosso banco");

        return new Estado(nome, pais);
    }
}