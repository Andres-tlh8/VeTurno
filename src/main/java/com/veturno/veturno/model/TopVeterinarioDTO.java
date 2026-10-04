package com.veturno.veturno.model;

public class TopVeterinarioDTO {

    private String veterinario;
    private long citas;

    public TopVeterinarioDTO() {
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public long getCitas() {
        return citas;
    }

    public void setCitas(long citas) {
        this.citas = citas;
    }
}