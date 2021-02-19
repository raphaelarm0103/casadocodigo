package br.com.api.casadocodigo.form;

import br.com.api.casadocodigo.Validador.UniqueValue;
import br.com.api.casadocodigo.modelo.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {

        @NotBlank(message = "Não pode ser vazio")
        @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O Pais já existe no banco de dados")
        private String nome;

    public String getNome() {
        return nome;
    }

    public Pais converter(){
        return new Pais(nome);
    }
}
