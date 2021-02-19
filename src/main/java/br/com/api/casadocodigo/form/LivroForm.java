package br.com.api.casadocodigo.form;

import br.com.api.casadocodigo.Validador.ExistsId;
import br.com.api.casadocodigo.Validador.UniqueValue;
import br.com.api.casadocodigo.modelo.Autor;
import br.com.api.casadocodigo.modelo.Categoria;
import br.com.api.casadocodigo.modelo.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "O campo livro não pode estar duplicado")
    private String titulo;
    @NotBlank @Size(max=500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal precoLivro;
    @Min(100)
    private Integer numerodePaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Número identificador não pode ser duplicado")
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal precoLivro, @Min(100) Integer
            numerodePaginas, @NotBlank String isbn, @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.numerodePaginas = numerodePaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro converter(EntityManager manager){
        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        return new Livro(titulo, resumo,sumario, precoLivro, numerodePaginas, isbn, dataPublicacao, categoria, autor);
    }
}
