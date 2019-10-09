package com.banco.avancado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Revisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participanteId")
    private Participante revisor;

    @Column(name = "nota", nullable = true)
    private int nota;

    @Column(name = "comentario", nullable = true)
    private String comentario;

    @ManyToMany(mappedBy = "autores")
    public List<Artigo> revisoes;
}
