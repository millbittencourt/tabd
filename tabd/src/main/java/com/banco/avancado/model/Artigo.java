package com.banco.avancado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = true)
    private String titulo;

    @Column(name = "resumo", nullable = true)
    private String resumo;

    @Column(name = "pdf", nullable = true)
    private byte[] pdf;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "artigo_Autor",
            joinColumns = { @JoinColumn(name = "artigoId") },
            inverseJoinColumns = { @JoinColumn(name = "participanteId") }
    )
    private List<Participante> autores;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "artigo_Revisao",
            joinColumns = { @JoinColumn(name = "artigoId") },
            inverseJoinColumns = { @JoinColumn(name = "revisaoId") }
    )
    public List<Revisao> revisoes;
}
