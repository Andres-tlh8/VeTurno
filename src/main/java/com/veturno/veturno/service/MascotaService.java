package com.veturno.veturno.service;

import com.veturno.veturno.model.Mascota;
import com.veturno.veturno.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> listarTodos() {
        return mascotaRepository.findAll();
    }

    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }
}
