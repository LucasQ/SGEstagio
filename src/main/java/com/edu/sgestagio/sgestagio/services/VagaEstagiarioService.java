package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.VagaEstagiario;
import com.edu.sgestagio.sgestagio.repositories.VagaEstagiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VagaEstagiarioService {
    @Autowired
    private VagaEstagiarioRepository repository;

    @Transactional
    public VagaEstagiario save(VagaEstagiario vagaEstagiario) {
        vagaEstagiario.setId_vaga_estagiario(null);
        return repository.save(vagaEstagiario);
    }
}
