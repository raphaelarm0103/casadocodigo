package br.com.api.casadocodigo.form;

import br.com.api.casadocodigo.modelo.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoriaForm {

    @NotBlank @Size(min=5)
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Categoria converter(){
        return new Categoria(this.nome);
    }
}
