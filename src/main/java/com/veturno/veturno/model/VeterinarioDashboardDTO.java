package com.veturno.veturno.model;

public class VeterinarioDashboardDTO {

    private String veterinario;
    private long totalCitas;
    private long programadas;
    private long atendidas;
    private long canceladas;

    public VeterinarioDashboardDTO() {
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public long getTotalCitas() {
        return totalCitas;
    }

    public void setTotalCitas(long totalCitas) {
        this.totalCitas = totalCitas;
    }

    public long getProgramadas() {
        return programadas;
    }

    public void setProgramadas(long programadas) {
        this.programadas = programadas;
    }

    public long getAtendidas() {
        return atendidas;
    }

    public void setAtendidas(long atendidas) {
        this.atendidas = atendidas;
    }

    public long getCanceladas() {
        return canceladas;
    }

    public void setCanceladas(long canceladas) {
        this.canceladas = canceladas;
    }
}