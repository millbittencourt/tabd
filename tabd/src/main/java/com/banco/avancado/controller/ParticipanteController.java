package com.banco.avancado.controller;

import com.banco.avancado.model.Participante;
import com.banco.avancado.repository.ParticipanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/participante"})
public class ParticipanteController {

    private ParticipanteRepository repository;

    ParticipanteController(ParticipanteRepository participanteController) { this.repository = participanteController; }

    @Transactional(rollbackFor=Exception.class)
    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @Transactional(rollbackFor=Exception.class)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Participante> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional(rollbackFor=Exception.class)
    @PostMapping
    public Participante create(@RequestBody Participante participante){
        return repository.save(participante);
    }

    @Transactional(rollbackFor=Exception.class)
    @PutMapping(value="/{id}")
    public ResponseEntity<Participante> update(@PathVariable("id") long id,
                                         @RequestBody Participante participante){
        return repository.findById(id)
                .map(record -> {
                    record.setNome(participante.getNome());
                    record.setTelefone(participante.getTelefone());
                    record.setEmail(participante.getEmail());
                    record.setEmpresa(participante.getEmpresa());
                    record.setRevisor(participante.isRevisor());
                    record.setEndereco(participante.getEndereco());
                    record.getArtigos().addAll(participante.getArtigos());
                    Participante updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Transactional(rollbackFor=Exception.class)
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
