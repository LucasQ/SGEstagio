package com.edu.sgestagio.sgestagio.resources;

import com.edu.sgestagio.sgestagio.domain.Vaga;
import com.edu.sgestagio.sgestagio.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vagas")
public class VagaResource {
    @Autowired
    private VagaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> findById(@PathVariable("id") Integer id_vaga) {
        return ResponseEntity.ok().body(service.findById(id_vaga));
    }
}
