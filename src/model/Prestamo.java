/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */

import java.util.Date;

public class Prestamo {
    private int id;
    private Usuario usuario;
    private Date fechaRegistro;
    private Date fechaLimite;
    private Date fechaDevolucion;
    private EstadoPrestamo estado;

    public Prestamo(int id, Usuario usuario, Date fechaRegistro, Date fechaLimite) {
        this.id = id;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.fechaLimite = fechaLimite;
        this.estado = EstadoPrestamo.ABIERTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

    public enum EstadoPrestamo {
        ABIERTO, PARCIALMENTE_CERRADO, COMPLETAMENTE_CERRADO
    }
}

