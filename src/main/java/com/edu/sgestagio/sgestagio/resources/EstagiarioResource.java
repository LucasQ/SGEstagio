package com.edu.sgestagio.sgestagio.resources;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.dto.EstagiarioDTO;
import com.edu.sgestagio.sgestagio.services.EstagiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estagiarios")
public class EstagiarioResource {
    @Autowired
    private EstagiarioService estagiarioService;

    @GetMapping
    public ResponseEntity<List<Estagiario>> findAll() {
        return ResponseEntity.ok().body(estagiarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estagiario> findById(@PathVariable("id") Integer id_estagiario) {
        return ResponseEntity.ok().body(estagiarioService.findById(id_estagiario));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody EstagiarioDTO estDTO) {
        Estagiario est = estagiarioService.insert(estDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(est.getId_estagiario()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
