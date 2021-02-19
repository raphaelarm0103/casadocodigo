package br.com.api.casadocodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;
    @Column(length = 400)
    private String descricao;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor() {
    }

    @Override
    public String toString() {
        return "Autor [nome=" + nome + "," + " email=" + email + ", " + "descricao=" + descricao + "," + " dataCriacao="
                + dataCriacao + "]";
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
