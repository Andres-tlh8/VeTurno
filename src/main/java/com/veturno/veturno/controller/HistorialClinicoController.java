package com.veturno.veturno.controller;

import com.veturno.veturno.model.HistorialClinico;
import com.veturno.veturno.service.HistorialClinicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historiales")
public class HistorialClinicoController {

    private final HistorialClinicoService historialClinicoService;

    public HistorialClinicoController(HistorialClinicoService historialClinicoService) {
        this.historialClinicoService = historialClinicoService;
    }

    @GetMapping
    public List<HistorialClinico> listarTodos() {
        return historialClinicoService.listarTodos();
    }

    @PostMapping
    public HistorialClinico guardar(@RequestBody HistorialClinico historialClinico) {
        return historialClinicoService.guardar(historialClinico);
    }

    @PutMapping("/{id}")
    public HistorialClinico actualizar(@PathVariable Long id,
                                       @RequestBody HistorialClinico historialClinico) {
        return historialClinicoService.actualizar(id, historialClinico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historialClinicoService.eliminar(id);
    }

    @GetMapping("/mascota/{id}")
    public List<HistorialClinico> buscarPorMascota(@PathVariable Long id) {
        return historialClinicoService.buscarPorMascota(id);
    }
}