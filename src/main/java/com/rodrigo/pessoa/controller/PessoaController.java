package com.rodrigo.pessoa.controller;

import com.rodrigo.pessoa.entity.Pessoa;
import com.rodrigo.pessoa.exception.PessoaNotFoundException;
import com.rodrigo.pessoa.service.PessoaService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPessoa(@Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaCreated = service.createPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCreated);
    }

    @GetMapping
    public ResponseEntity getPessoas(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPessoas(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getPessoaById(@PathVariable Long id) throws PessoaNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPessoaById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updatePessoa(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) throws PessoaNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePessoa(id, pessoa));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePessoa(@PathVariable Long id) throws PessoaNotFoundException {
        service.deletePessoa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
