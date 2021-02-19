package br.com.api.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.api.casadocodigo.form.AutorForm;
import br.com.api.casadocodigo.form.CategoriaForm;
import br.com.api.casadocodigo.modelo.Autor;
import br.com.api.casadocodigo.modelo.Categoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String cadastroAutor(@RequestBody @Valid AutorForm form) {
        Autor autor = form.converter();
        manager.persist(autor);
        return autor.toString();
    }

    }

