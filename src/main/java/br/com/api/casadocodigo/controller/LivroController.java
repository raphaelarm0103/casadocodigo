package br.com.api.casadocodigo.controller;

import br.com.api.casadocodigo.form.AutorForm;
import br.com.api.casadocodigo.form.LivroForm;
import br.com.api.casadocodigo.modelo.Livro;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String cadastroLivro(@RequestBody @Valid LivroForm form){
        Livro livro = form.converter(manager);
        manager.persist(livro);
        return livro.toString();
    }

}
