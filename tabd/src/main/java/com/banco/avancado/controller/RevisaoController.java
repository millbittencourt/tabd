package com.banco.avancado.controller;

import com.banco.avancado.model.Artigo;
import com.banco.avancado.model.Revisao;
import com.banco.avancado.repository.RevisaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/revisao"})
public class RevisaoController {

    private RevisaoRepository repository;

    RevisaoController(RevisaoRepository revisaoRepository) {this.repository = revisaoRepository;}

    @Transactional(rollbackFor = Exception.class)
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Revisao> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping
    public Revisao create(@RequestBody Revisao revisao) {
        return repository.save(revisao);
    }

    @Transactional(rollbackFor = Exception.class)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Revisao> update(@PathVariable("id") long id,
                                         @RequestBody Revisao revisao) {
        return repository.findById(id)
                .map(record -> {
                    record.setRevisor(revisao.getRevisor());
                    record.setNota(revisao.getNota());
                    record.setComentario(revisao.getComentario());
                    record.getRevisoes().addAll(revisao.getRevisoes());
                    Revisao updated = repository.save(record);
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
