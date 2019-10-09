package com.banco.avancado.controller;

import com.banco.avancado.model.Artigo;
import com.banco.avancado.model.Cartao;
import com.banco.avancado.repository.CartaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/cartao"})
public class CartaoController {

    private CartaoRepository repository;

    CartaoController(CartaoRepository cartaoRepository) {this.repository = cartaoRepository;}

    @Transactional(rollbackFor=Exception.class)
    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @Transactional(rollbackFor=Exception.class)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Cartao> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional(rollbackFor=Exception.class)
    @PostMapping
    public Cartao create(@RequestBody Cartao cartao){
        return repository.save(cartao);
    }

    @Transactional(rollbackFor=Exception.class)
    @PutMapping(value="/{id}")
    public ResponseEntity<Cartao> update(@PathVariable("id") long id,
                                         @RequestBody Cartao cartao){
        return repository.findById(id)
                .map(record -> {
                    record.setNumero(cartao.getNumero());
                    record.setDataVencimento(cartao.getDataVencimento());
                    record.setMarca(cartao.getMarca());
                    record.setParticipante(cartao.getParticipante());
                    Cartao updated = repository.save(record);
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
