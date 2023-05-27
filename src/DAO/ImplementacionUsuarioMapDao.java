/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.Usuario;

/**
 *
 * @author diego
 */
public class ImplementacionUsuarioMapDao implements UsuarioDao {

    Map<Integer, Usuario> UsuarioMap = new HashMap<>();

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> list = new ArrayList<>();
        Iterator it = UsuarioMap.values().iterator();
        while (it.hasNext()) {
            list.add((Usuario) it.next());
        }
        return list;
    }

    @Override
    public Usuario getUsuario(int id) {
        Usuario usuario = null;
        if (UsuarioMap.containsKey(id)) {
            usuario = UsuarioMap.get(id);
        }
        return usuario;
    }

    @Override
    public boolean addUsuario(Usuario usuario) {
        UsuarioMap.put(usuario.getCodigo(), usuario);
        return true;
    }

    @Override
    public boolean updateUsiario(int codigo, Usuario usuario) {
    if (UsuarioMap.containsKey(codigo)) {
        Usuario usuarioExistente = UsuarioMap.get(codigo);
        usuarioExistente.setName(usuario.getName());
        usuarioExistente.setOcupacion(usuario.getOcupacion());
        usuarioExistente.setPrestamoaActivo(usuario.isPrestamoaActivo());
        usuarioExistente.setParcialmenteActivo(usuario.isParcialmenteActivo());
        return true;
    }
    return false;
}


    @Override
    public boolean deleteUsuario(int codigo, Usuario usuario) {
        UsuarioMap.remove(usuario.getCodigo());
        return true;
    }
}
