package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.InstituicaoEnsino;
import com.edu.sgestagio.sgestagio.dto.EstagiarioDTO;
import com.edu.sgestagio.sgestagio.repositories.EstagiarioRepository;
import com.edu.sgestagio.sgestagio.repositories.InstituicaoEnsinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstagiarioService {
    @Autowired
    private EstagiarioRepository estagiarioRepository;
    @Autowired
    private InstituicaoEnsinoRepository instituicaoEnsinoRepository;

    public List<Estagiario> findAll() {
        return estagiarioRepository.findAll();
    }

    public Estagiario insert(EstagiarioDTO estDTO) {
        Optional<InstituicaoEnsino> instituicaoEnsino = instituicaoEnsinoRepository.findById(estDTO.getId_instituicao_ensino());
        Estagiario est = fromDTO(estDTO);
        est.setId_instituicao_ensino(instituicaoEnsino.get());
        return estagiarioRepository.save(est);
    }

    public Estagiario fromDTO(EstagiarioDTO estDTO) {
        return new Estagiario(estDTO.getId_estagiario(), estDTO.getNome(), estDTO.getTelefone(), estDTO.getCpf(),
                estDTO.getEmail(), estDTO.getData_nascimento(), estDTO.getNacionalidade(), estDTO.getNivel());
    }

    public Estagiario findById(Integer id_estagiario) {
        return estagiarioRepository.findById(id_estagiario).get();
    }
}
