package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.InstituicaoEnsino;
import com.edu.sgestagio.sgestagio.domain.UnidadeLotacao;
import com.edu.sgestagio.sgestagio.domain.Vaga;
import com.edu.sgestagio.sgestagio.domain.enums.Status;
import com.edu.sgestagio.sgestagio.repositories.EstagiarioRepository;
import com.edu.sgestagio.sgestagio.repositories.InstituicaoEnsinoRepository;
import com.edu.sgestagio.sgestagio.repositories.UnidadeLotacaoRepository;
import com.edu.sgestagio.sgestagio.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;

@Service
public class DBService {
    @Autowired
    private EstagiarioRepository estagiarioRepository;
    @Autowired
    private InstituicaoEnsinoRepository instituicaoEnsinoRepository;
    @Autowired
    private UnidadeLotacaoRepository unidadeLotacaoRepository;
    @Autowired
    private VagaRepository vagasRepository;


    public void InstantiateDataBase() throws ParseException {
        Estagiario est1 = new Estagiario(null, "Guilherme Morais Zaleski", " 9 83762227",
                "06344128960", "gui@gmail.com", new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-20"), "Brasil", 1);

        InstituicaoEnsino ie1 = new InstituicaoEnsino(null, "UnB");
        InstituicaoEnsino ie2 = new InstituicaoEnsino(null, "Unip");
        instituicaoEnsinoRepository.saveAll(Arrays.asList(ie1, ie2));

        est1.setId_instituicao_ensino(ie1);
        estagiarioRepository.saveAll(Collections.singletonList(est1));
    }

    public void InstantiateVagasDB() {
        //organograma do ministerio da fazenda
        UnidadeLotacao ul1 = new UnidadeLotacao(null, "PGNF", "Proc. Geral da Fazenda Nacional");
        UnidadeLotacao ul2 = new UnidadeLotacao(null, "RFB", "Sec. da Receita Federal do Brasil");
        UnidadeLotacao ul3 = new UnidadeLotacao(null, "STN", "Sec. do Tesouro Nacional");
        UnidadeLotacao ul4 = new UnidadeLotacao(null, "SEPRAC", "Secretaria de Promocao da Produtividade e Advocacia Economica");
        UnidadeLotacao ul5 = new UnidadeLotacao(null, "SEFEL", "Secretaria de Acompanhamento Fiscal, Energia e Loteria");
        UnidadeLotacao ul6 = new UnidadeLotacao(null, "SEAE", "Secretaria de Acomp. Economico");
        UnidadeLotacao ul7 = new UnidadeLotacao(null, "SAIN", "Sec. de Assuntos Internacionais");
        UnidadeLotacao ul8 = new UnidadeLotacao(null, "ESAF", "Esc. de Administracao Fazendaria");
        UnidadeLotacao ul9 = new UnidadeLotacao(null, "SPREV", "Sec Previdencia");
        UnidadeLotacao ul10 = new UnidadeLotacao(null, "CMN", "Conselho Monetario Nacional");
        UnidadeLotacao ul11 = new UnidadeLotacao(null, "CONFAZ", "Conselho Nacional de Pol. Fazendaria");

        unidadeLotacaoRepository.saveAll(Arrays.asList(ul1, ul2, ul3, ul4, ul5, ul6, ul7, ul8, ul9, ul10, ul11));

        Vaga vg1 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg2 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg3 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg4 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg5 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg6 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg7 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg8 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg9 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg10 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg11 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg12 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg13 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg14 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg15 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg16 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg17 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg18 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg19 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg20 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg21 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg22 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg23 = new Vaga(null, Status.DISPONIVEL);


        vg1.setId_unidade_lotacao(ul1);
        vg2.setId_unidade_lotacao(ul2);
        vg3.setId_unidade_lotacao(ul3);
        vg4.setId_unidade_lotacao(ul4);
        vg5.setId_unidade_lotacao(ul5);
        vg6.setId_unidade_lotacao(ul6);
        vg7.setId_unidade_lotacao(ul7);
        vg8.setId_unidade_lotacao(ul8);
        vg9.setId_unidade_lotacao(ul9);
        vg10.setId_unidade_lotacao(ul10);
        vg11.setId_unidade_lotacao(ul11);
        vg12.setId_unidade_lotacao(ul1);
        vg13.setId_unidade_lotacao(ul2);
        vg14.setId_unidade_lotacao(ul3);
        vg15.setId_unidade_lotacao(ul4);
        vg16.setId_unidade_lotacao(ul5);
        vg17.setId_unidade_lotacao(ul6);
        vg18.setId_unidade_lotacao(ul7);
        vg19.setId_unidade_lotacao(ul8);
        vg20.setId_unidade_lotacao(ul9);
        vg21.setId_unidade_lotacao(ul10);
        vg22.setId_unidade_lotacao(ul1);
        vg23.setId_unidade_lotacao(ul2);

        vagasRepository.saveAll(Arrays.asList(vg1, vg2, vg3, vg4, vg5, vg6, vg7, vg8, vg9, vg10, vg11, vg12, vg13,
                vg14, vg15, vg16, vg17, vg18, vg19, vg20, vg21, vg22, vg23));
    }
}

