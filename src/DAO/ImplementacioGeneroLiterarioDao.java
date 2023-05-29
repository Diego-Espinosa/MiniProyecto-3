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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.GeneroLiterario;

public class ImplementacioGeneroLiterarioDao implements GeneroLiterarioDAO {
    private Map<Integer, GeneroLiterario> generosLiterarios;
    private int nextId;

    public ImplementacioGeneroLiterarioDao() {
        this.generosLiterarios = new HashMap<>();
        this.nextId = 1;
    }
    
    public GeneroLiterario buscarGeneroLiterarioPorId(int id) {
        return generosLiterarios.get(id);
    }
    @Override
    public void crearGeneroLiterario(GeneroLiterario generoLiterario) {
        generoLiterario.setId(nextId);
        generosLiterarios.put(nextId, generoLiterario);
        nextId++;
    }

    @Override
    public GeneroLiterario obtenerGeneroLiterario(int id) {
        return generosLiterarios.get(id);
    }

    @Override
    public List<GeneroLiterario> listarGenerosLiterarios() {
        return generosLiterarios.values().stream().collect(Collectors.toList());
    }

    @Override
    public void eliminarGeneroLiterario(int id) {
        generosLiterarios.remove(id);
    }

    @Override
    public void actualizarGeneroLiterario(GeneroLiterario generoLiterario) {
        generosLiterarios.put(generoLiterario.getId(), generoLiterario);
    }
}

