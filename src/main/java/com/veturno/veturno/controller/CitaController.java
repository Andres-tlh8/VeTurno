package com.veturno.veturno.controller;

import com.veturno.veturno.model.Cita;
import com.veturno.veturno.service.CitaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> listarTodos() {
        return citaService.listarTodos();
    }

    @PostMapping
    public Cita guardar(@RequestBody Cita cita) {
        return citaService.guardar(cita);
    }

    @PutMapping("/{id}")
    public Cita actualizar(@PathVariable Long id,
                           @RequestBody Cita cita) {

        return citaService.actualizar(id, cita);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Cita> buscarPorEstado(@PathVariable String estado) {
        return citaService.buscarPorEstado(estado);
    }

    @GetMapping("/mascota/{id}")
    public List<Cita> buscarPorMascota(@PathVariable Long id) {
        return citaService.buscarPorMascota(id);
    }

    @GetMapping("/veterinario/{id}")
    public List<Cita> buscarPorVeterinario(@PathVariable Long id) {
        return citaService.buscarPorVeterinario(id);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Cita> buscarPorFecha(@PathVariable LocalDate fecha) {
        return citaService.buscarPorFecha(fecha);
    }

    @GetMapping("/rango")
    public List<Cita> buscarPorRango(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fin) {

        return citaService.buscarPorRango(inicio, fin);
    }
}