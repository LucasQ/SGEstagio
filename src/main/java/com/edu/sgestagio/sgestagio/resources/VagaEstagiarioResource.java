package com.edu.sgestagio.sgestagio.resources;

import com.edu.sgestagio.sgestagio.domain.VagaEstagiario;
import com.edu.sgestagio.sgestagio.dto.VagaEstagiarioDTO;
import com.edu.sgestagio.sgestagio.services.VagaEstagiarioService;
import com.edu.sgestagio.sgestagio.services.exceptions.VagaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vagaestagiario")
public class VagaEstagiarioResource {
    /*
        Operacoes:
        - Inserir o id_estagiario e o id_vaga com o dt_fim null e dt_hr_atualiz sysdate
        - Excecao ao tentar inserir em uma vaga de status OCUPADO, PEDENTE ou BLOQUEADO
        - Encerrar uma VagaEstagiario colocando um DT_FIM desejado e mudando o status da Vaga para DISPONIVEL
        - Retornar VagaEstagiario com nome da unidade lotacao(UnidadeLotacao) e status(Vaga), dependendo da URI
          pode listar ou tudo(sem parametro) ou encerradas(DT_FIM not null) ou nao encerradas
        - Retorno unico dos mesmos dados da operacao anterior, porem pesquisando por CPF. na URI
    */
    @Autowired
    private VagaEstagiarioService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody VagaEstagiarioDTO vagaEstagiarioDTO) throws VagaException {
        VagaEstagiario ve = service.fromDto(vagaEstagiarioDTO);
        ve = service.save(ve);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(ve.getId_vaga_estagiario()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
