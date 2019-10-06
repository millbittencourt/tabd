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
public class Revisao {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Participante revisor;
    // private Artigo artigo;
    private int nota;
    private String comentario;

    public List<Artigo> artigos;
}
