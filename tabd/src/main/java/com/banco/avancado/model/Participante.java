package com.banco.avancado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
public class Participante {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String empresa;
    private boolean revisor;
    private Endereco endereco;

    public List<Artigo> artigos;
}
