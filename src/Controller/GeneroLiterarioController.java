/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GeneroLiterarioDAO;
import java.util.List;
import model.GeneroLiterario;

/**
 *
 * @author ASUS
 */

public class GeneroLiterarioController {
    private GeneroLiterarioDAO generoLiterarioDao;

    public GeneroLiterarioController(GeneroLiterarioDAO generoLiterarioDao) {
        this.generoLiterarioDao = generoLiterarioDao;
    }

    public void crearGeneroLiterario(String nombre) {
        GeneroLiterario generoLiterario = new GeneroLiterario(0, nombre); // El ID se asignará automáticamente
        generoLiterarioDao.crearGeneroLiterario(generoLiterario);
    }

    public GeneroLiterario buscarGeneroLiterarioPorNombre(String nombre) {
        List<GeneroLiterario> generosLiterarios = generoLiterarioDao.listarGenerosLiterarios();
        for (GeneroLiterario generoLiterario : generosLiterarios) {
            if (generoLiterario.getNombre().equalsIgnoreCase(nombre)) {
                return generoLiterario;
            }
        }
        return null;
    }
    
    public GeneroLiterario obtenerGeneroLiterario(int id) {
        return generoLiterarioDao.obtenerGeneroLiterario(id);
    }

    public List<GeneroLiterario> listarGenerosLiterarios() {
        return generoLiterarioDao.listarGenerosLiterarios();
    }

    public void actualizarGeneroLiterario(int id, String nombre) {
        GeneroLiterario generoLiterarioExistente = generoLiterarioDao.obtenerGeneroLiterario(id);
        if (generoLiterarioExistente != null) {
            generoLiterarioExistente.setNombre(nombre);
            generoLiterarioDao.actualizarGeneroLiterario(generoLiterarioExistente);
        }
    }

    public void eliminarGeneroLiterario(int id) {
        generoLiterarioDao.eliminarGeneroLiterario(id);
    }
}

