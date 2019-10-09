package com.banco.avancado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua", nullable = true)
    private String rua;

    @Column(name = "bairro", nullable = true)
    private String bairro;

    @Column(name = "cidade", nullable = true)
    private String cidade;

    @Column(name = "estado", nullable = true)
    private String estado;

    @Column(name = "complemento", nullable = true)
    private String complemento;
}
