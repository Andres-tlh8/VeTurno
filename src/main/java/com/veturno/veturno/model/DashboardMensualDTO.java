package com.veturno.veturno.model;

public class DashboardMensualDTO {

    private String mes;
    private long totalCitasMes;
    private long programadas;
    private long atendidas;
    private long canceladas;

    public DashboardMensualDTO() {
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public long getTotalCitasMes() {
        return totalCitasMes;
    }

    public void setTotalCitasMes(long totalCitasMes) {
        this.totalCitasMes = totalCitasMes;
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
