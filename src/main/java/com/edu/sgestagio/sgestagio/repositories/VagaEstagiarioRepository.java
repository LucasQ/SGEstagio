package com.edu.sgestagio.sgestagio.repositories;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.VagaEstagiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VagaEstagiarioRepository extends JpaRepository<VagaEstagiario, Integer> {
    @Query("select v from VagaEstagiario v where v.dt_fim is null")
    List<VagaEstagiario> findByDt_fimIsNull();
    @Query("select v from VagaEstagiario v where v.dt_fim is not null")
    List<VagaEstagiario> findByDt_fimNotNull();
    @Query("select v from VagaEstagiario v where v.id_estagiario= ?1")
    VagaEstagiario findByIdestagiario(Estagiario est);
}
