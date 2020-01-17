package com.edu.sgestagio.sgestagio.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id_unidade_lotacao")
public class UnidadeLotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_unidade_lotacao;
    private String nome_unidade;
    private String descricao;

    @OneToMany(mappedBy = "id_unidade_lotacao")
    private List<Vaga> vagas = new ArrayList<>();

    public UnidadeLotacao(Integer id_unidade_lotacao, String nome_unidade, String descricao) {
        this.id_unidade_lotacao = id_unidade_lotacao;
        this.nome_unidade = nome_unidade;
        this.descricao = descricao;
    }
}
