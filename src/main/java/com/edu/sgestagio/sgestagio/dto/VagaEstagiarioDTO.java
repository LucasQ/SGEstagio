package com.edu.sgestagio.sgestagio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class VagaEstagiarioDTO {
    private Integer id_vaga;
    private Integer id_estagiario;
    private String dt_inicio;
    private String dt_hr_atualiz;
}
