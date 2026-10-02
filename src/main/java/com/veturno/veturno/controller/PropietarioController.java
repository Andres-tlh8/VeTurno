package com.veturno.veturno.controller;

import com.veturno.veturno.model.Propietario;
import com.veturno.veturno.service.PropietarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

public PropietarioController(PropietarioService propietarioService) {
            this.propietarioService = propietarioService;
}

    @GetMapping
    public List<Propietario> listarTodos() {
        return propietarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Propietario buscarPorId(@PathVariable Long id) {
        return propietarioService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Propietario guardar(@RequestBody Propietario propietario) {
        return propietarioService.guardar(propietario);
    }

    @PutMapping("/{id}")
    public Propietario actualizar(
            @PathVariable Long id,
            @RequestBody Propietario propietario) {

        return propietarioService.actualizar(id, propietario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
    }
}