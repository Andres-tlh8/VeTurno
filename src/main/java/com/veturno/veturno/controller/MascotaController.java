package com.veturno.veturno.controller;

import com.veturno.veturno.model.Mascota;
import com.veturno.veturno.service.MascotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<Mascota> listarTodos() {
        return mascotaService.listarTodos();
    }

    @PostMapping
    public Mascota guardar(@RequestBody Mascota mascota) {
        return mascotaService.guardar(mascota);
    }
}