package com.banco.avancado.controller;

import com.banco.avancado.model.Artigo;
import com.banco.avancado.repository.ArtigoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/artigo"})
public class ArtigoController {

    private ArtigoRepository repository;

    ArtigoController(ArtigoRepository artigoRepository) {
        this.repository = artigoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Artigo> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping
    public Artigo create(@RequestBody Artigo artigo) {
        return repository.save(artigo);
    }

    @Transactional(rollbackFor = Exception.class)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Artigo> update(@PathVariable("id") long id,
                                         @RequestBody Artigo artigo) {
        return repository.findById(id)
                .map(record -> {
                    record.setTitulo(artigo.getTitulo());
                    record.setResumo(artigo.getResumo());
                    record.setPdf(artigo.getPdf());
                    record.getAutores().addAll(artigo.getAutores());
                    record.getRevisoes().addAll(artigo.getRevisoes());
                    Artigo updated = repository.save(record);
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
