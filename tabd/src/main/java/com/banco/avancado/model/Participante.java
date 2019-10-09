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
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(name = "telefone", nullable = true)
    private String telefone;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "empresa", nullable = true)
    private String empresa;

    @Column(name = "revisor", nullable = true)
    private boolean revisor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enderecoId")
    private Endereco endereco;

    @ManyToMany(mappedBy = "autores")
    public List<Artigo> artigos;
}
