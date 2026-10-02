package com.veturno.veturno.service;

import com.veturno.veturno.model.HistorialClinico;
import com.veturno.veturno.repository.HistorialClinicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialClinicoService {

    private final HistorialClinicoRepository historialClinicoRepository;

    public HistorialClinicoService(HistorialClinicoRepository historialClinicoRepository) {
        this.historialClinicoRepository = historialClinicoRepository;
    }

    public List<HistorialClinico> listarTodos() {
        return historialClinicoRepository.findAll();
    }

    public HistorialClinico guardar(HistorialClinico historialClinico) {
        return historialClinicoRepository.save(historialClinico);
    }

    public HistorialClinico actualizar(Long id,
                                       HistorialClinico historialActualizado) {

        HistorialClinico historial = historialClinicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        historial.setFechaConsulta(historialActualizado.getFechaConsulta());
        historial.setDiagnostico(historialActualizado.getDiagnostico());
        historial.setTratamiento(historialActualizado.getTratamiento());
        historial.setObservaciones(historialActualizado.getObservaciones());
        historial.setPeso(historialActualizado.getPeso());
        historial.setMascota(historialActualizado.getMascota());

        return historialClinicoRepository.save(historial);
    }

    public void eliminar(Long id) {
        historialClinicoRepository.deleteById(id);
    }
}