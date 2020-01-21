package com.edu.sgestagio.sgestagio.resources;

import com.edu.sgestagio.sgestagio.domain.VagaEstagiario;
import com.edu.sgestagio.sgestagio.dto.UpdateVagaEstagiarioDTO;
import com.edu.sgestagio.sgestagio.dto.VagaEstagiarioDTO;
import com.edu.sgestagio.sgestagio.services.VagaEstagiarioService;
import com.edu.sgestagio.sgestagio.services.exceptions.VagaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/vagaestagiario")
public class VagaEstagiarioResource {
    /*
        Operacoes:
        x Inserir o id_estagiario e o id_vaga com o dt_fim null e dt_hr_atualiz sysdate
        x Excecao ao tentar inserir em uma vaga de status OCUPADO, PEDENTE ou BLOQUEADO
        x Encerrar uma VagaEstagiario colocando um DT_FIM desejado e mudando o status da Vaga para DISPONIVEL
        x Retornar VagaEstagiario com nome da unidade lotacao(UnidadeLotacao) e status(Vaga), dependendo da URI
          pode listar ou tudo(sem parametro) ou encerradas(DT_FIM not null) ou nao encerradas
        x Retorno unico dos mesmos dados da operacao anterior, porem pesquisando por CPF. na URI
    */
    @Autowired
    private VagaEstagiarioService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody VagaEstagiarioDTO objDto) throws VagaException, ParseException {
        VagaEstagiario ve = service.fromDto(objDto);
        ve = service.save(ve);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(ve.getId_vaga_estagiario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> encerrarVaga(@PathVariable("id") Integer id, @RequestBody UpdateVagaEstagiarioDTO date)
            throws VagaException, ParseException {
        VagaEstagiario ve = service.encerrarVaga(id, date.getDt_fim());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = {"","/{status}"})
    public ResponseEntity<List<VagaEstagiario>> showVagaEstagiarioByDtFim(
            @PathVariable(value = "status", required = false) String status) {
        return ResponseEntity.ok().body(service.findAll(status));
    }

    @GetMapping("/bycpf/{cpf}")
    public ResponseEntity<VagaEstagiario> showVagaEstagiarioByCpf(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok().body(service.findByCpf(cpf));
    }
}
