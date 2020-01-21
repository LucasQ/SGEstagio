package com.edu.sgestagio.sgestagio.repositories;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstagiarioRepository extends JpaRepository<Estagiario, Integer> {
    @Query("select est from Estagiario est where est.cpf = :cpf")
    Estagiario findByCpf(@Param("cpf") String cpf);
//    Estagiario findByCpf(String cpf);
}