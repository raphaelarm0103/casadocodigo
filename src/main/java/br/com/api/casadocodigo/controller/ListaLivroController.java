package br.com.api.casadocodigo.controller;

import br.com.api.casadocodigo.form.ListaLivro;
import br.com.api.casadocodigo.modelo.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lista-livro")
public class ListaLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    @Transactional
    public List<ListaLivro> listaLivro(){
        return manager.createQuery("select l from Livro l", Livro.class)
                .getResultStream()
                .map(ListaLivro::new)
                .collect(Collectors.toList());
    }
}

