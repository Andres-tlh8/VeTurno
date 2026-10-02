package com.veturno.veturno.service;

import com.veturno.veturno.model.Cita;
import com.veturno.veturno.repository.CitaRepository;
import org.springframework.stereotype.Service;

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
        cita.setMascota(citaActualizada.getMascota());
        cita.setVeterinario(citaActualizada.getVeterinario());

        return citaRepository.save(cita);
    }

    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
}
