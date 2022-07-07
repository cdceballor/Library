package com.ceiba.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="BIBLIOTECATABLA")
public class PrestamoModelo  {
    @Id
    private @GeneratedValue int id;
    private String isbn;
    private String idUser;
    private int tipoUsuario; //1 afiliado, 2 empleado de la biblioteca, 3 invitado
    
    public PrestamoModelo() {}
    
    public PrestamoModelo(String idUser, String isbn, int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        this.isbn = isbn;
        this.idUser = idUser;
    }

    public String getIdUser() {
        return this.idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public static String convert() {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        return formattedDate;
    }
}
