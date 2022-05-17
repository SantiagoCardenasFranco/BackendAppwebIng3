package com.uco.myproject.dominio.validador;

import com.uco.myproject.dominio.servicio.ServicioObtenerHoraActual;

import java.time.LocalTime;

public class ValidadorHora {

    private static final String HORA_CIERRE_SISTEMA = "21:00:00.000";
    private static final String HORA_APERTURA_SISTEMA = "09:00:00.000";
    private static final String DESPUES_DE_HORA = "No se puede ingresar despues de la hora establecida";

    private ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ValidadorHora(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public void validarHora() {
        LocalTime hora = servicioObtenerHoraActual.ejecutar();
        LocalTime horaCierre = LocalTime.parse(HORA_CIERRE_SISTEMA);
        LocalTime horaApertura = LocalTime.parse(HORA_APERTURA_SISTEMA);
        if (horaCierre.isBefore(hora) || horaApertura.isAfter(hora)) {
            throw new IllegalStateException(DESPUES_DE_HORA);

        }
    }
}
