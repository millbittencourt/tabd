package com.banco.avancado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = true)
    private String numero;

    @Column(name = "dataVencimento", nullable = true)
    private Date dataVencimento;

    @Column(name = "marca", nullable = true)
    private String marca;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participanteId")
    private Participante participante;
}
