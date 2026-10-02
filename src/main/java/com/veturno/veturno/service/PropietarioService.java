package com.veturno.veturno.service;

import com.veturno.veturno.model.Propietario;
import com.veturno.veturno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public List<Propietario> listarTodos() {
        return propietarioRepository.findAll();
    }

    public Optional<Propietario> buscarPorId(Long id) {
        return propietarioRepository.findById(id);
    }

    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public Propietario actualizar(Long id, Propietario propietarioActualizado) {

        Propietario propietario = propietarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado"));

        propietario.setNombre(propietarioActualizado.getNombre());
        propietario.setTelefono(propietarioActualizado.getTelefono());
        propietario.setCorreo(propietarioActualizado.getCorreo());

        return propietarioRepository.save(propietario);
    }

    public void eliminar(Long id) {
        propietarioRepository.deleteById(id);
    }
}