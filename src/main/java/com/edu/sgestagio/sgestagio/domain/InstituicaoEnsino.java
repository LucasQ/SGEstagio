package com.edu.sgestagio.sgestagio.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InstituicaoEnsino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_instituicao_ensino;
    private String nome_instituicao;

    public InstituicaoEnsino(Integer id_instituicao_ensino, String nome_instituicao) {
        this.id_instituicao_ensino = id_instituicao_ensino;
        this.nome_instituicao = nome_instituicao;
    }
}
