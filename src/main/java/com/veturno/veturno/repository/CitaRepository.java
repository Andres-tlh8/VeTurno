package com.veturno.veturno.repository;

import com.veturno.veturno.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByEstado(String estado);

    List<Cita> findByMascotaId(Long mascotaId);

    List<Cita> findByVeterinarioId(Long veterinarioId);

    List<Cita> findByFechaHoraBetween(
            LocalDateTime inicio,
            LocalDateTime fin);
}