package com.veturno.veturno.repository;

import com.veturno.veturno.model.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialClinicoRepository
        extends JpaRepository<HistorialClinico, Long> {
}