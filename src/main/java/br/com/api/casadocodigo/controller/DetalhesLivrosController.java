package br.com.api.casadocodigo.controller;


import br.com.api.casadocodigo.form.DetalheLivroForm;
import br.com.api.casadocodigo.modelo.Livro;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/livros/{id}")
public class DetalhesLivrosController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    @Transactional
    public ResponseEntity<DetalheLivroForm> lista(@PathVariable Long id){
            Livro listaLivro = manager.find(Livro.class, id);
            if(listaLivro == null){
                return (ResponseEntity<DetalheLivroForm>) ResponseEntity.status(HttpStatus.NOT_FOUND);
            }
            DetalheLivroForm detalhesLivro = new DetalheLivroForm(listaLivro);
            return ResponseEntity.ok(detalhesLivro);
    }

}
