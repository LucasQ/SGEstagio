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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VagaEstagiarioService {
    @Autowired
    private VagaEstagiarioRepository repository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private EstagiarioRepository estagiarioRepository;

    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");


    @Transactional
    public VagaEstagiario save(VagaEstagiario vagaEstagiario) throws VagaException {
        if (vagaEstagiario.getId_vaga().getId_status() != Status.DISPONIVEL.getCod()) {
            throw new VagaException("A vaga nao esta disponivel");
        }
        vagaEstagiario.setId_vaga_estagiario(null);
        vagaEstagiario.getId_vaga().setId_status(Status.OCUPADO);
        return repository.save(vagaEstagiario);
    }

    public VagaEstagiario fromDto(VagaEstagiarioDTO objDto) throws ParseException {
        Optional<Vaga> vg = vagaRepository.findById(objDto.getId_vaga());
        Optional<Estagiario> est = estagiarioRepository.findById(objDto.getId_estagiario());
        return new VagaEstagiario(null, vg.get(), est.get(), format.parse(objDto.getDt_inicio()),
                null, format.parse(objDto.getDt_hr_atualiz()));
    }

    @Transactional
    public VagaEstagiario encerrarVaga(Integer id_vaga_estagiario, String dt_fim) throws VagaException, ParseException {
        Optional<VagaEstagiario> ve = repository.findById(id_vaga_estagiario);
        Date dt = format.parse(dt_fim);

        if (ve.get().getId_vaga().getId_status() != Status.OCUPADO.getCod())
            throw new VagaException("A vaga nao se encontra ocupada");

        if (ve.get().getDt_fim() != null)
            throw new VagaException("A vaga ja foi encerrada");

        ve.get().getId_vaga().setId_status(Status.DISPONIVEL);
        ve.get().setDt_fim(new Date());
        ve.get().setDt_hr_atualiz(new Date());
        ve.get().setDt_fim(dt);

        return repository.save(ve.get());
    }

    public List<VagaEstagiario> findAll(String status) {
        if (status == null)
            return repository.findAll();
        if (status.equals("encerrados"))
            return repository.findByDt_fimNotNull();
        else if (status.equals("ativos"))
            return repository.findByDt_fimIsNull();
        else
            return repository.findAll();
    }

    public VagaEstagiario findByCpf(String cpf) {
        Estagiario est = estagiarioRepository.findByCpf(cpf);
        return repository.findByIdestagiario(est);
    }
}