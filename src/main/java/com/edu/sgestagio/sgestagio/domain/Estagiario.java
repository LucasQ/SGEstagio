package com.edu.sgestagio.sgestagio.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String cpf;
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;
    private String nacionalidade;
    private int nivel;

    @ManyToOne
    @JoinColumn(name = "id_instituicao_ensino")
    private InstituicaoEnsino id_instituicao_ensino;

    public Estagiario(Integer id_estagiario, String nome, String telefone, String cpf,
                      String email, Date data_nascimento, String nacionalidade, int nivel) {
        this.id_estagiario = id_estagiario;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.nacionalidade = nacionalidade;
        this.nivel = nivel;
    }
}
