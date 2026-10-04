package com.veturno.veturno.repository;

import com.veturno.veturno.model.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long> {

    List<HistorialClinico> findByMascotaId(Long mascotaId);

}