package com.veturno.veturno.controller;

import com.veturno.veturno.dto.MascotaRequest;
import com.veturno.veturno.model.Mascota;
import com.veturno.veturno.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<Mascota> listarTodos() {
        return mascotaService.listarTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/validar")
    public String validarMascota(
            @Valid
            @RequestBody MascotaRequest request) {

        return "Datos válidos";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Mascota guardar(@RequestBody Mascota mascota) {
        return mascotaService.guardar(mascota);
    }
}