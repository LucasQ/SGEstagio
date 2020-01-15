package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.InstituicaoEnsino;
import com.edu.sgestagio.sgestagio.repositories.EstagiarioRepository;
import com.edu.sgestagio.sgestagio.repositories.InstituicaoEnsinoRepository;
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

    public void InstantiateDataBase() throws ParseException {
        Estagiario est1 = new Estagiario(null, "Guilherme Morais Zaleski", " 9 83762227",
                "06344128960", "gui@gmail.com", new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-20"), "Brasil", 1);

        InstituicaoEnsino ie1 = new InstituicaoEnsino(null, "UnB");
        InstituicaoEnsino ie2 = new InstituicaoEnsino(null, "Unip");
        instituicaoEnsinoRepository.saveAll(Arrays.asList(ie1, ie2));

        est1.setId_instituicao_ensino(ie1);
        estagiarioRepository.saveAll(Collections.singletonList(est1));
    }
}

