package com.edu.sgestagio.sgestagio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class VagaEstagiarioDTO {
    private Integer id_vaga;
    private Integer id_estagiario;
    private Date dt_inicio;
    private Date dt_fim;
    private Date dt_hr_atualiz;
}
