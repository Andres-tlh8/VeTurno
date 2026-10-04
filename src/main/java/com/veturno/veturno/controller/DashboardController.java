package com.veturno.veturno.controller;

import com.veturno.veturno.model.DashboardDTO;
import com.veturno.veturno.model.DashboardHoyDTO;
import com.veturno.veturno.model.DashboardMensualDTO;
import com.veturno.veturno.model.TopVeterinarioDTO;
import com.veturno.veturno.model.VeterinarioDashboardDTO;
import com.veturno.veturno.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardDTO dashboard() {
        return dashboardService.obtenerDashboard();
    }

    @GetMapping("/veterinario/{id}")
    public VeterinarioDashboardDTO dashboardVeterinario(
            @PathVariable Long id) {

        return dashboardService.obtenerDashboardVeterinario(id);
    }

    @GetMapping("/hoy")
    public DashboardHoyDTO dashboardHoy() {
        return dashboardService.obtenerDashboardHoy();
    }

    @GetMapping("/mensual")
    public DashboardMensualDTO dashboardMensual() {
        return dashboardService.obtenerDashboardMensual();
    }

    @GetMapping("/top-veterinarios")
    public List<TopVeterinarioDTO> topVeterinarios() {

        return dashboardService.obtenerTopVeterinarios();
    }
}