package com.banco.avancado.controller;

import com.banco.avancado.model.Artigo;
import com.banco.avancado.model.Endereco;
import com.banco.avancado.repository.EnderecoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/endereco"})
public class EnderecoController {

    private EnderecoRepository repository;

    EnderecoController(EnderecoRepository enderecoRepository) {
        this.repository = enderecoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Endereco> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping
    public Endereco create(@RequestBody Endereco endereco) {
        return repository.save(endereco);
    }

    @Transactional(rollbackFor = Exception.class)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable("id") long id,
                                         @RequestBody Endereco endereco) {
        return repository.findById(id)
                .map(record -> {
                    record.setRua(endereco.getRua());
                    record.setBairro(endereco.getBairro());
                    record.setCidade(endereco.getCidade());
                    record.setEstado(endereco.getEstado());
                    record.setComplemento(endereco.getComplemento());
                    Endereco updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
