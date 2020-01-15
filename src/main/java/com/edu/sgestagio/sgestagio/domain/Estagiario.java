package com.edu.sgestagio.sgestagio.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Estagiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estagiario;
    private String nome;
    private String telefone;
    private int cpf;
    private String email;
    private Date data_nascimento;
    private String nacionalidade;
    private int nivel;

    @ManyToOne
    @JoinColumn(name = "id_instituicao_ensino")
    private InstituicaoEnsino id_instituicao_ensino;
}
