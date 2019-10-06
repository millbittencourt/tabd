package com.banco.avancado.controller;

import com.banco.avancado.model.Artigo;
import com.banco.avancado.repository.ArtigoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/artigo"})
public class ArtigoController {

    private ArtigoRepository repository;

    ArtigoController(ArtigoRepository artigoRepository){
        this.repository = artigoRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Artigo> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Artigo create(@RequestBody Artigo contact){
        return repository.save(contact);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Artigo> update(@PathVariable("id") long id,
                                          @RequestBody Artigo artigo){
        return repository.findById(id)
                .map(record -> {
                    record.setTitulo(artigo.getTitulo());
                    record.setResumo(artigo.getResumo());
                    record.setPdf(artigo.getPdf());
                    Artigo updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
