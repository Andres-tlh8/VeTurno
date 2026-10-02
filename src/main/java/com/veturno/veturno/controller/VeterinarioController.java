package com.veturno.veturno.controller;

import com.veturno.veturno.model.Veterinario;
import com.veturno.veturno.service.VeterinarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public List<Veterinario> listarTodos() {
        return veterinarioService.listarTodos();
    }

    @PostMapping
    public Veterinario guardar(@RequestBody Veterinario veterinario) {
        return veterinarioService.guardar(veterinario);
    }
}