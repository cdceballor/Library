package com.ceiba.biblioteca;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.model.PrestamoModelo;
import com.ceiba.biblioteca.repository.PrestamoRepositorio;

@RestController
public class PrestamoControlador {
    
    @Autowired
    private PrestamoRepositorio servicio;

    @PostMapping("/prestamo")
    public PrestamoModelo crear(@RequestBody PrestamoModelo prestamo) {
        return servicio.save(prestamo);
    }

    @GetMapping("/list")
    public  List<PrestamoModelo> index() {
        return servicio.findAll();
    }

    @GetMapping("/prestamo/{id}")
    public Optional<PrestamoModelo> getPrestamoById(@PathVariable int id) {
        return servicio.findById(id);
    }
}
