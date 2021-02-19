package br.com.api.casadocodigo.form;

import br.com.api.casadocodigo.modelo.Livro;

public class ListaLivro {

    private Long id;
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public ListaLivro(Livro livro){
        id = livro.getId();
        titulo = livro.getTitulo();
    }
}
