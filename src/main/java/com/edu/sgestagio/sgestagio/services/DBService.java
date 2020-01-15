package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.InstituicaoEnsino;
import com.edu.sgestagio.sgestagio.domain.UnidadeLotacao;
import com.edu.sgestagio.sgestagio.domain.Vaga;
import com.edu.sgestagio.sgestagio.domain.enums.Status;
import com.edu.sgestagio.sgestagio.repositories.EstagiarioRepository;
import com.edu.sgestagio.sgestagio.repositories.InstituicaoEnsinoRepository;
import com.edu.sgestagio.sgestagio.repositories.UnidadeLotacaoRepository;
import com.edu.sgestagio.sgestagio.repositories.VagasRepository;
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
    private VagasRepository vagasRepository;


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

        Vaga vg1 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg2 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg3 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg4 = new Vaga(null, Status.DISPONIVEL);
        Vaga vg5 = new Vaga(null, Status.DISPONIVEL);



    }
}

