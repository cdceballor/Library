package com.ceiba.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.model.PrestamoModelo;

@Repository
public interface PrestamoRepositorio extends JpaRepository<PrestamoModelo, Integer> {

    PrestamoModelo findByidentificacionUsuario(String idUser);

}
