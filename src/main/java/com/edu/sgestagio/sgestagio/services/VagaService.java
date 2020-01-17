package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.Vaga;
import com.edu.sgestagio.sgestagio.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {
    @Autowired
    private VagaRepository repository;

    public Vaga findById(Integer id_vaga) {
        return repository.findById(id_vaga).get();
    }
}
