/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import model.Prestamo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrestamoImplementacionDao {
    private Map<Integer, Prestamo> prestamos;

    public PrestamoImplementacionDao() {
        this.prestamos = new HashMap<>();
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getId(), prestamo);
    }

    public Prestamo consultarPrestamo(int id) {
        return prestamos.get(id);
    }

    public void actualizarPrestamo(Prestamo prestamo) {
        if (prestamos.containsKey(prestamo.getId())) {
            prestamos.put(prestamo.getId(), prestamo);
        }
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo.getId());
    }

    public List<Prestamo> obtenerTodosLosPrestamos() {
        return new ArrayList<>(prestamos.values());
    }
}
