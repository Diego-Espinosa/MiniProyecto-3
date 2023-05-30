/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author ASUS
 *
 * */

import model.Prestamo;
import java.util.List;

public interface PrestamoDAO {
    void agregarPrestamo(Prestamo prestamo);

    Prestamo consultarPrestamo(int id);

    void actualizarPrestamo(Prestamo prestamo);

    void eliminarPrestamo(Prestamo prestamo);

    List<Prestamo> obtenerTodosLosPrestamos();
}
