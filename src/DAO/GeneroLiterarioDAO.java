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
import java.util.List;
import model.GeneroLiterario;

public interface GeneroLiterarioDAO {
    void crearGeneroLiterario(GeneroLiterario generoLiterario);
    GeneroLiterario obtenerGeneroLiterario(int id);
    List<GeneroLiterario> listarGenerosLiterarios();
    void actualizarGeneroLiterario(GeneroLiterario generoLiterario);
    void eliminarGeneroLiterario(int id);
}

