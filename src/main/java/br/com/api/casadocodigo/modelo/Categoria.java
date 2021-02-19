package br.com.api.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    @NotBlank @Size(min=2)
    private String nome;


    public Categoria(@NotBlank @Size(min = 5) String nome) {
        super();
        this.nome = nome;
    }

    public Categoria() {
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
