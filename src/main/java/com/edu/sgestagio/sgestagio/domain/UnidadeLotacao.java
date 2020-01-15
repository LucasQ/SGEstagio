package com.edu.sgestagio.sgestagio.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UnidadeLotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_unidade_lotacao;
    private String nome_unidade;
    private String descricao;

    public UnidadeLotacao(Integer id_unidade_lotacao, String nome_unidade, String descricao) {
        this.id_unidade_lotacao = id_unidade_lotacao;
        this.nome_unidade = nome_unidade;
        this.descricao = descricao;
    }
}
