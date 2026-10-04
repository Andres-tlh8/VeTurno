package com.veturno.veturno.model;

public class DashboardHoyDTO {

    private String fecha;
    private long citasHoy;
    private long programadas;
    private long atendidas;
    private long canceladas;

    public DashboardHoyDTO() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getCitasHoy() {
        return citasHoy;
    }

    public void setCitasHoy(long citasHoy) {
        this.citasHoy = citasHoy;
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