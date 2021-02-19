package br.com.api.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estados", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "pais_id"}))

public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Estado estado) {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}