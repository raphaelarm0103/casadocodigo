package br.com.api.casadocodigo.controller;


import br.com.api.casadocodigo.form.ClienteForm;
import br.com.api.casadocodigo.modelo.Cliente;
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
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> cadastraCliente(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.converter(manager);

        manager.persist(cliente);
        return ResponseEntity.ok(cliente);
    }

}
