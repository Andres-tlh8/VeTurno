package com.veturno.veturno.service;

import com.veturno.veturno.model.Cita;
import com.veturno.veturno.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> listarTodos() {
        return citaRepository.findAll();
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizar(Long id, Cita citaActualizada) {

        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        cita.setFechaHora(citaActualizada.getFechaHora());
        cita.setMotivo(citaActualizada.getMotivo());
        cita.setEstado(citaActualizada.getEstado());
        cita.setMascota(citaActualizada.getMascota());
        cita.setVeterinario(citaActualizada.getVeterinario());

        return citaRepository.save(cita);
    }

    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }

    public List<Cita> buscarPorEstado(String estado) {
        return citaRepository.findByEstado(estado);
    }

    public List<Cita> buscarPorMascota(Long mascotaId) {
        return citaRepository.findByMascotaId(mascotaId);
    }

    public List<Cita> buscarPorVeterinario(Long veterinarioId) {
        return citaRepository.findByVeterinarioId(veterinarioId);
    }

    public List<Cita> buscarPorFecha(LocalDate fecha) {

        LocalDateTime inicio = fecha.atStartOfDay();
        LocalDateTime fin = fecha.atTime(23, 59, 59);

        return citaRepository.findByFechaHoraBetween(
                inicio,
                fin);
    }

    public List<Cita> buscarPorRango(
            LocalDate inicio,
            LocalDate fin) {

        LocalDateTime fechaInicio = inicio.atStartOfDay();

        LocalDateTime fechaFin = fin.atTime(23, 59, 59);

        return citaRepository.findByFechaHoraBetween(
                fechaInicio,
                fechaFin);
    }
}