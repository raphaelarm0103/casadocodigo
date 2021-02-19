package br.com.api.casadocodigo.controller;

import br.com.api.casadocodigo.form.CategoriaForm;
import br.com.api.casadocodigo.modelo.Categoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String cadastroCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.converter();
        manager.persist(categoria);
        return categoria.toString();
    }
}

