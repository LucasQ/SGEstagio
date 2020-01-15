package com.edu.sgestagio.sgestagio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class EstagiarioDTO {
    private Integer id_estagiario;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private Date data_nascimento;
    private String nacionalidade;
    private int nivel;
    private int id_instituicao_ensino;
}
