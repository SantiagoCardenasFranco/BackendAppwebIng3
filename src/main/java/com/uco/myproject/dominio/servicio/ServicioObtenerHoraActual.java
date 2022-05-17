package com.uco.myproject.dominio.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ServicioObtenerHoraActual {

    public LocalTime ejecutar() {
        return LocalTime.now();
    }
}
