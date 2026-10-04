package com.veturno.veturno.service;

import com.veturno.veturno.dto.AuthResponse;
import com.veturno.veturno.dto.LoginRequest;
import com.veturno.veturno.dto.RegisterRequest;
import com.veturno.veturno.model.Role;
import com.veturno.veturno.model.Usuario;
import com.veturno.veturno.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(
            UsuarioRepository usuarioRepository,
            JwtService jwtService,
            BCryptPasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());

        usuario.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        usuario.setRole(Role.USER);

        usuarioRepository.save(usuario);

        return new AuthResponse(
                "Usuario registrado correctamente"
        );
    }

    public AuthResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado"
                        ));

        if (!passwordEncoder.matches(
                request.getPassword(),
                usuario.getPassword()
        )) {

            throw new RuntimeException(
                    "Credenciales inválidas"
            );
        }

        String token = jwtService.generateToken(
                usuario.getEmail()
        );

        return new AuthResponse(
                "Login exitoso",
                token
        );
    }
}