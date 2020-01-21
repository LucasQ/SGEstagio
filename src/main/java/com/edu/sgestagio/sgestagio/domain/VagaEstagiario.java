package com.edu.sgestagio.sgestagio.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VagaEstagiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vaga_estagiario;

    @ManyToOne
    @JoinColumn(name = "id_vaga")
    private Vaga id_vaga;

    @ManyToOne
    @JoinColumn(name = "id_estagiario")
    private Estagiario id_estagiario;
    private Date dt_inicio;
    private Date dt_fim;
    private Date dt_hr_atualiz;
}
