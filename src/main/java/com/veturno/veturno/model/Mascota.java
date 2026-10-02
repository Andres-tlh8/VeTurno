package com.veturno.veturno.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String especie;

    private String raza;

    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;
}