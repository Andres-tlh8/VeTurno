package com.veturno.veturno.service;

import com.veturno.veturno.model.Cita;
import com.veturno.veturno.model.DashboardDTO;
import com.veturno.veturno.model.DashboardHoyDTO;
import com.veturno.veturno.model.DashboardMensualDTO;
import com.veturno.veturno.model.TopVeterinarioDTO;
import com.veturno.veturno.model.Veterinario;
import com.veturno.veturno.model.VeterinarioDashboardDTO;
import com.veturno.veturno.repository.CitaRepository;
import com.veturno.veturno.repository.MascotaRepository;
import com.veturno.veturno.repository.PropietarioRepository;
import com.veturno.veturno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private final PropietarioRepository propietarioRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;
    private final CitaRepository citaRepository;

    public DashboardService(
            PropietarioRepository propietarioRepository,
            MascotaRepository mascotaRepository,
            VeterinarioRepository veterinarioRepository,
            CitaRepository citaRepository) {

        this.propietarioRepository = propietarioRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
        this.citaRepository = citaRepository;
    }

    public DashboardDTO obtenerDashboard() {

        DashboardDTO dashboard = new DashboardDTO();

        dashboard.setTotalPropietarios(propietarioRepository.count());
        dashboard.setTotalMascotas(mascotaRepository.count());
        dashboard.setTotalVeterinarios(veterinarioRepository.count());
        dashboard.setTotalCitas(citaRepository.count());

        dashboard.setCitasProgramadas(
                citaRepository.findByEstado("PROGRAMADA").size());

        dashboard.setCitasAtendidas(
                citaRepository.findByEstado("ATENDIDA").size());

        dashboard.setCitasCanceladas(
                citaRepository.findByEstado("CANCELADA").size());

        return dashboard;
    }

    public VeterinarioDashboardDTO obtenerDashboardVeterinario(Long id) {

        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Veterinario no encontrado"));

        List<Cita> citas =
                citaRepository.findByVeterinarioId(id);

        VeterinarioDashboardDTO dto =
                new VeterinarioDashboardDTO();

        dto.setVeterinario(veterinario.getNombre());

        dto.setTotalCitas(citas.size());

        dto.setProgramadas(
                citas.stream()
                        .filter(c -> "PROGRAMADA".equals(c.getEstado()))
                        .count());

        dto.setAtendidas(
                citas.stream()
                        .filter(c -> "ATENDIDA".equals(c.getEstado()))
                        .count());

        dto.setCanceladas(
                citas.stream()
                        .filter(c -> "CANCELADA".equals(c.getEstado()))
                        .count());

        return dto;
    }

    public DashboardHoyDTO obtenerDashboardHoy() {

        LocalDate hoy = LocalDate.now();

        LocalDateTime inicio =
                hoy.atStartOfDay();

        LocalDateTime fin =
                hoy.atTime(23, 59, 59);

        List<Cita> citasHoy =
                citaRepository.findByFechaHoraBetween(
                        inicio,
                        fin);

        DashboardHoyDTO dto =
                new DashboardHoyDTO();

        dto.setFecha(hoy.toString());

        dto.setCitasHoy(citasHoy.size());

        dto.setProgramadas(
                citasHoy.stream()
                        .filter(c -> "PROGRAMADA".equals(c.getEstado()))
                        .count());

        dto.setAtendidas(
                citasHoy.stream()
                        .filter(c -> "ATENDIDA".equals(c.getEstado()))
                        .count());

        dto.setCanceladas(
                citasHoy.stream()
                        .filter(c -> "CANCELADA".equals(c.getEstado()))
                        .count());

        return dto;
    }

    public DashboardMensualDTO obtenerDashboardMensual() {

        YearMonth mesActual = YearMonth.now();

        LocalDateTime inicio =
                mesActual.atDay(1).atStartOfDay();

        LocalDateTime fin =
                mesActual.atEndOfMonth()
                        .atTime(23, 59, 59);

        List<Cita> citasMes =
                citaRepository.findByFechaHoraBetween(
                        inicio,
                        fin);

        DashboardMensualDTO dto =
                new DashboardMensualDTO();

        dto.setMes(mesActual.toString());

        dto.setTotalCitasMes(citasMes.size());

        dto.setProgramadas(
                citasMes.stream()
                        .filter(c -> "PROGRAMADA".equals(c.getEstado()))
                        .count());

        dto.setAtendidas(
                citasMes.stream()
                        .filter(c -> "ATENDIDA".equals(c.getEstado()))
                        .count());

        dto.setCanceladas(
                citasMes.stream()
                        .filter(c -> "CANCELADA".equals(c.getEstado()))
                        .count());

        return dto;
    }

    public List<TopVeterinarioDTO> obtenerTopVeterinarios() {

        List<Veterinario> veterinarios =
                veterinarioRepository.findAll();

        List<TopVeterinarioDTO> resultado =
                new ArrayList<>();

        for (Veterinario veterinario : veterinarios) {

            long totalCitas =
                    citaRepository.findByVeterinarioId(
                                    veterinario.getId())
                            .size();

            TopVeterinarioDTO dto =
                    new TopVeterinarioDTO();

            dto.setVeterinario(
                    veterinario.getNombre());

            dto.setCitas(totalCitas);

            resultado.add(dto);
        }

        resultado.sort(
                (a, b) ->
                        Long.compare(
                                b.getCitas(),
                                a.getCitas()));

        return resultado;
    }
}