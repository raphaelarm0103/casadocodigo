package br.com.api.casadocodigo.controller;

import br.com.api.casadocodigo.form.PaisForm;
import br.com.api.casadocodigo.modelo.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Pais> criaPais(@RequestBody @Valid PaisForm form) {
        Pais estado = new Pais(form.getNome());

        manager.persist(estado);

        return ResponseEntity.ok(estado);
    }

}