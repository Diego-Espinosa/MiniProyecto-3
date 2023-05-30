/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diego
 */
public class Usuario {

    private static int sequence = 0;
    private int codigo;
    private String name;
    private String ocupacion;
    private boolean prestamoaActivo=false;
    private boolean parcialmenteActivo=false;

    public Usuario(int codigo, String name, String ocupacion) {
        this.codigo = ++sequence;
        this.name = name;
        this.ocupacion = ocupacion;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public boolean isPrestamoaActivo() {
        return prestamoaActivo;
    }

    public void setPrestamoaActivo(boolean prestamoaActivo) {
        this.prestamoaActivo = prestamoaActivo;
    }

    public boolean isParcialmenteActivo() {
        return parcialmenteActivo;
    }

    public void setParcialmenteActivo(boolean parcialmenteActivo) {
        this.parcialmenteActivo = parcialmenteActivo;
    }
    
}