/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Usuario;
/**
 *
 * @author diego
 */
public interface UsuarioDao {
    public List<Usuario> getUsuarios();
    public Usuario getUsuario(int id);
    public boolean addUsuario(Usuario usuario);
    public boolean updateUsiario(int codigo,
            Usuario usuario);
    public boolean deleteUsuario(int codigo, Usuario usuario);
}
