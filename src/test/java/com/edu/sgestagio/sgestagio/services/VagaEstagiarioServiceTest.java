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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VagaEstagiarioServiceTest {
    @Mock
    private VagaRepository vagaRepository;
    @Mock
    private EstagiarioRepository estagiarioRepository;
    @Mock
    private VagaEstagiarioRepository vagaEstagiarioRepository;
    @InjectMocks
    private VagaEstagiarioService service;
    private static DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void insertVagaNaoDisponivelTest() {
        VagaEstagiario ve = new VagaEstagiario(null, new Vaga(1, Status.OCUPADO), new Estagiario(),
                new Date(), new Date(), new Date());

        assertThatThrownBy(() -> service.save(ve))
                .isInstanceOf(VagaException.class)
                .hasMessage("A vaga nao esta disponivel");

//        Assertions.assertThrows(VagaException.class,() -> service.save(ve));
    }

    @Test
    public void fromDtoTest() throws ParseException {
        int id = 99;
        Vaga vg = new Vaga(id, Status.DISPONIVEL);
        Estagiario est = new Estagiario(id);
        VagaEstagiarioDTO vDto = new VagaEstagiarioDTO(vg.getId_vaga(), est.getId_estagiario(),
                "21/12/2019", "21/12/2019");

        when(vagaRepository.findById(vg.getId_vaga())).thenReturn(Optional.of(vg));
        when(estagiarioRepository.findById(est.getId_estagiario())).thenReturn(Optional.of(est));

        VagaEstagiario ve = service.fromDto(vDto);

        Assertions.assertEquals(ve.getId_vaga().getId_vaga(), vDto.getId_vaga());
        Assertions.assertEquals(ve.getId_estagiario().getId_estagiario(), vDto.getId_estagiario());

        verify(vagaRepository, times(1)).findById(id);
        verify(estagiarioRepository, times(1)).findById(id);
    }

    //- Encerrar uma VagaEstagiario colocando um DT_FIM desejado e mudando o status da Vaga para DISPONIVEL
    @Test
    public void EncerrarVagaEstagiarioTest() throws ParseException, VagaException {
        int id = 99;
        Vaga vg = new Vaga(id, Status.OCUPADO);
        VagaEstagiario ve = new VagaEstagiario(id, vg, new Estagiario(),
                sdf.parse("21/12/2012"), null, sdf.parse("06/06/2015"));

        when(vagaEstagiarioRepository.findById(id)).thenReturn(Optional.of(ve));
        when(vagaEstagiarioRepository.save(ve)).thenReturn(new VagaEstagiario(id, new Vaga(id, Status.DISPONIVEL),
                new Estagiario(), sdf.parse("21/12/2012"), sdf.parse("03/03/2020"), new Date()));

        VagaEstagiario veUpt = service.encerrarVaga(ve.getId_vaga_estagiario(), "03/03/2020");

        Assertions.assertEquals(veUpt.getId_vaga().getId_status(), Status.DISPONIVEL.getCod());
        Assertions.assertNotNull(veUpt.getDt_fim());
        Assertions.assertTrue(equalsDate(veUpt.getDt_hr_atualiz(), new Date()));
        Assertions.assertTrue(equalsDate(veUpt.getDt_fim(), sdf.parse("03/03/2020")));

        verify(vagaEstagiarioRepository, times(1)).findById(id);
        verify(vagaEstagiarioRepository, times(1)).save(ve);
    }

    private static boolean equalsDate(Date d1, Date d2) throws ParseException {
        return sdf.parse(sdf.format(d1)).compareTo(sdf.parse(sdf.format(d2))) == 0;
    }

    @Test
    public void encerrarVagaEstagioNaoOcupadaTest() throws ParseException {
        int id = 99;
        Vaga vg = new Vaga(id, Status.DISPONIVEL);
        VagaEstagiario ve = new VagaEstagiario(id, vg, new Estagiario(),
                sdf.parse("21/12/2012"), null, sdf.parse("06/06/2015"));

        when(vagaEstagiarioRepository.findById(id)).thenReturn(Optional.of(ve));

        assertThatThrownBy(() -> service.encerrarVaga(ve.getId_vaga_estagiario(), "03/03/2020"))
                .isInstanceOf(VagaException.class)
                .hasMessage("A vaga nao se encontra ocupada");
    }

    @Test
    public void encerrarVagaEstagioJaEncerrada() throws ParseException {
        int id = 99;
        Vaga vg = new Vaga(id, Status.OCUPADO);
        VagaEstagiario ve = new VagaEstagiario(id, vg, new Estagiario(),
                sdf.parse("21/12/2012"), new Date(), sdf.parse("06/06/2015"));

        when(vagaEstagiarioRepository.findById(id)).thenReturn(Optional.of(ve));

        assertThatThrownBy(() -> service.encerrarVaga(ve.getId_vaga_estagiario(), "03/03/2020"))
                .isInstanceOf(VagaException.class)
                .hasMessage("A vaga ja foi encerrada");
    }
}
