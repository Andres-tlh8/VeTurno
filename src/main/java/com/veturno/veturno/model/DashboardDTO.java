package com.veturno.veturno.model;

public class DashboardDTO {

    private long totalPropietarios;
    private long totalMascotas;
    private long totalVeterinarios;
    private long totalCitas;
    private long citasProgramadas;
    private long citasAtendidas;
    private long citasCanceladas;

    public DashboardDTO() {
    }

    public long getTotalPropietarios() {
        return totalPropietarios;
    }

    public void setTotalPropietarios(long totalPropietarios) {
        this.totalPropietarios = totalPropietarios;
    }

    public long getTotalMascotas() {
        return totalMascotas;
    }

    public void setTotalMascotas(long totalMascotas) {
        this.totalMascotas = totalMascotas;
    }

    public long getTotalVeterinarios() {
        return totalVeterinarios;
    }

    public void setTotalVeterinarios(long totalVeterinarios) {
        this.totalVeterinarios = totalVeterinarios;
    }

    public long getTotalCitas() {
        return totalCitas;
    }

    public void setTotalCitas(long totalCitas) {
        this.totalCitas = totalCitas;
    }

    public long getCitasProgramadas() {
        return citasProgramadas;
    }

    public void setCitasProgramadas(long citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }

    public long getCitasAtendidas() {
        return citasAtendidas;
    }

    public void setCitasAtendidas(long citasAtendidas) {
        this.citasAtendidas = citasAtendidas;
    }

    public long getCitasCanceladas() {
        return citasCanceladas;
    }

    public void setCitasCanceladas(long citasCanceladas) {
        this.citasCanceladas = citasCanceladas;
    }
}