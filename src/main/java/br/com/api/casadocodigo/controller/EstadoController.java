package br.com.api.casadocodigo.controller;

import br.com.api.casadocodigo.form.EstadoForm;
import br.com.api.casadocodigo.modelo.Estado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> criaEstado(@RequestBody @Valid EstadoForm form) {

        Estado estado = form.converter(manager);

        manager.persist(estado);

        return ResponseEntity.ok(estado);

    }

}