package com.edu.sgestagio.sgestagio.domain;

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
public class InstituicaoEnsino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_instituicao_ensino;
    private String nome_instituicao;

    @OneToMany(mappedBy = "id_instituicao_ensino")
    private List<Estagiario> estagiarios = new ArrayList<>();

    public InstituicaoEnsino(Integer id_instituicao_ensino, String nome_instituicao) {
        this.id_instituicao_ensino = id_instituicao_ensino;
        this.nome_instituicao = nome_instituicao;
    }
}
