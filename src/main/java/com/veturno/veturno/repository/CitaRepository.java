package com.veturno.veturno.repository;

import com.veturno.veturno.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}