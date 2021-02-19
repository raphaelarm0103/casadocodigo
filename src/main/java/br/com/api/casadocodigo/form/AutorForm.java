package br.com.api.casadocodigo.form;

import br.com.api.casadocodigo.Validador.UniqueValue;
import br.com.api.casadocodigo.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotBlank
    @Size(min=5)
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size (max=400)
    private String descricao;

    public AutorForm(@NotBlank @Size(min = 5) String nome, @NotBlank @Email String email, @NotBlank @Size (max=400) String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
  }

  public Autor converter(){
        return new Autor(this.nome, this.email, this.descricao);
  }
}
