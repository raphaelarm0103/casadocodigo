package br.com.api.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="pais")
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Pais() {
    }
    public Pais(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome(){
        return  nome;
    }
}
