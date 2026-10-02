package com.veturno.veturno.service;

import com.veturno.veturno.model.Veterinario;
import com.veturno.veturno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    public Veterinario guardar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }
}
