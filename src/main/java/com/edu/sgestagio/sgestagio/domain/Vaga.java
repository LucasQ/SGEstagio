package com.edu.sgestagio.sgestagio.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vaga;
    private int id_status;

    @ManyToOne
    @JoinColumn(name = "id_unidade_lotacao")
    private UnidadeLotacao id_unidade_lotacao;

    public Vaga(Integer id_vaga, int id_status) {
        this.id_vaga = id_vaga;
        this.id_status = id_status;
    }
}
