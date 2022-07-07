package com.ceiba.biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.errors.PrestamoUsuarioInvitadoExcepcion;
import com.ceiba.biblioteca.errors.PrestamoUsuarioNoPermitidoExcepcion;
import com.ceiba.biblioteca.model.PrestamoModelo;
import com.ceiba.biblioteca.repository.PrestamoRepositorio;

@RestController
public class PrestamoControlador {
    
    @Autowired
    private PrestamoRepositorio servicio;

    @PostMapping("/prestamo")
    public PrestamoModelo crear(@RequestBody PrestamoModelo prestamo) {
        Date dt = fechaMaxima(prestamo.getTipoUsuario());
        prestamo.setFechaMaximaDevolucion(dt);
        PrestamoModelo existe = servicio.findByidentificacionUsuario(prestamo.getIdentificacionUsuario());
        if (prestamo.getTipoUsuario() > 3 ||0 > prestamo.getTipoUsuario()) {
            throw new PrestamoUsuarioNoPermitidoExcepcion();
        } else {
            if (existe == null) {
                return servicio.save(prestamo);
            } else {
                throw new PrestamoUsuarioInvitadoExcepcion(prestamo.getIdentificacionUsuario());
            }
        }
    }

    @GetMapping("/list")
    public  List<PrestamoModelo> index() {
        return servicio.findAll();
    }

    @GetMapping("/prestamo/{id}")
    public Optional<PrestamoModelo> getPrestamoById(@PathVariable int id) {
        return servicio.findById(id);
    }

    public Date fechaMaxima(int tipoUsuario) {
        Date date = new Date();
        switch (tipoUsuario) {
            case 1:
                date = fechaUtils(10);
                break;
            case 2:
                date = fechaUtils(8);
                break;
            case 3:
                date = fechaUtils(7);
                break;
            default:
                break;
        }
        return date;
    }

    public Date fechaUtils(int dias) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, dias);
        dt = c.getTime();
        return dt;
    }

}
