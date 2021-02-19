package br.com.api.casadocodigo.form;

import br.com.api.casadocodigo.modelo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class DetalheLivroForm {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal precoLivro;
    private Integer numerodePaginas;
    private String isbn;
    private LocalDate dataPublicacao;

    public DetalheLivroForm(Livro livro) {
       titulo = livro.getTitulo();
       resumo = livro.getResumo();
       sumario = livro.getSumario();
       precoLivro = livro.getPrecoLivro();
       numerodePaginas = livro.getNumerodePaginas();
       isbn = livro.getIsbn();
       dataPublicacao = livro.getDataPublicacao();
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPrecoLivro() {
        return precoLivro;
    }

    public Integer getNumerodePaginas() {
        return numerodePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

}
