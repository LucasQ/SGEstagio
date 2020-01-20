package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.Vaga;
import com.edu.sgestagio.sgestagio.domain.VagaEstagiario;
import com.edu.sgestagio.sgestagio.domain.enums.Status;
import com.edu.sgestagio.sgestagio.dto.VagaEstagiarioDTO;
import com.edu.sgestagio.sgestagio.repositories.EstagiarioRepository;
import com.edu.sgestagio.sgestagio.repositories.VagaEstagiarioRepository;
import com.edu.sgestagio.sgestagio.repositories.VagaRepository;
import com.edu.sgestagio.sgestagio.services.exceptions.VagaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class VagaEstagiarioService {
    @Autowired
    private VagaEstagiarioRepository repository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private EstagiarioRepository estagiarioRepository;

    @Transactional
    public VagaEstagiario save(VagaEstagiario vagaEstagiario) throws VagaException {
        if (vagaEstagiario.getId_vaga().getId_status() != Status.DISPONIVEL.getCod()) {
            throw new VagaException("A vaga nao esta disponivel");
        }
        vagaEstagiario.setId_vaga_estagiario(null);
        return repository.save(vagaEstagiario);
    }

    public VagaEstagiario fromDto(VagaEstagiarioDTO objDto) {
        Optional<Vaga> vg = vagaRepository.findById(objDto.getId_vaga());
        Optional<Estagiario> est = estagiarioRepository.findById(objDto.getId_estagiario());
        return new VagaEstagiario(null, vg.get(), est.get(), objDto.getDt_inicio(),
                objDto.getDt_fim(), objDto.getDt_hr_atualiz());
    }

    public VagaEstagiario encerrarVaga(Integer id_vaga_estagiario) {
        Optional<VagaEstagiario> ve = repository.findById(id_vaga_estagiario);
        ve.get().getId_vaga().setId_status(Status.DISPONIVEL);
        ve.get().setDt_fim(new Date());
        ve.get().setDt_hr_atualiz(new Date());

        return repository.save(ve.get());
    }
}