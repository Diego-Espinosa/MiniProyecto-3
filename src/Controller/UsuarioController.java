/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDao;
import java.util.List;
import model.Usuario;

/**
 *
 * @author ASUS
 */
public class UsuarioController {
    private UsuarioDao usuarioDao;

    public UsuarioController(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    public Usuario getUsuario(int id) {
        return usuarioDao.getUsuario(id);
    }

    public void agregarUsuario(String nombre, String ocupacion, boolean prestamoActivo, boolean parcialmenteActivo) {
    Usuario usuario = new Usuario(0, nombre, ocupacion); // El código se asignará automáticamente
    usuario.setPrestamoaActivo(prestamoActivo);
    usuario.setParcialmenteActivo(parcialmenteActivo);
    usuarioDao.addUsuario(usuario);
}


    public void actualizarUsuario(int codigo, String nombre, String ocupacion, boolean prestamoActivo, boolean parcialmenteActivo) {
        Usuario usuarioExistente = usuarioDao.getUsuario(codigo);
        if (usuarioExistente != null) {
            usuarioExistente.setName(nombre);
            usuarioExistente.setOcupacion(ocupacion);
            usuarioExistente.setPrestamoaActivo(prestamoActivo);
            usuarioExistente.setParcialmenteActivo(parcialmenteActivo);
            usuarioDao.updateUsiario(codigo, usuarioExistente);
        }
    }

    public void eliminarUsuario(int codigo) {
        Usuario usuarioExistente = usuarioDao.getUsuario(codigo);
        if (usuarioExistente != null) {
            usuarioDao.deleteUsuario(codigo, usuarioExistente);
        }
    }
}
