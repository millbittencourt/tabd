package com.banco.avancado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
public class Cartao {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private Date dataVencimento;
    private String marca;
    private Participante participante;
}
