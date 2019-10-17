package com.banco.avancado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    @JsonBackReference("artigos")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "artigos")
    private List<Participante> autores;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "artigo_revisao",
            joinColumns =  @JoinColumn(name = "artigo_id") ,
            inverseJoinColumns = @JoinColumn(name = "revisao_id")
    )
    public List<Revisao> revisoes;
}
