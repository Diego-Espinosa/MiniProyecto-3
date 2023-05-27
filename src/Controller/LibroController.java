/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LibroDao;
import java.util.List;
import model.Libro;

/**
 *
 * @author ASUS
 */
public class LibroController {
    private LibroDao libroDao;

    public LibroController(LibroDao libroDao) {
        this.libroDao = libroDao;
    }

    public List<Libro> listarLibros() {
        return libroDao.listarLibros();
    }

    public Libro obtenerLibroPorCodigo(int codigo) {
        return libroDao.obtenerLibroPorCodigo(codigo);
    }

    public void agregarLibro(String genero, String titulo, String autor, String ejemplares) {
        Libro libro = new Libro(genero, 0, titulo, autor, ejemplares); // El código se asignará automáticamente
        libroDao.agregarLibro(libro);
    }

    public void actualizarLibro(int codigo, String genero, String titulo, String autor, String ejemplares) {
        Libro libroExistente = libroDao.obtenerLibroPorCodigo(codigo);
        if (libroExistente != null) {
            libroExistente.setGenero(genero);
            libroExistente.setTitulo(titulo);
            libroExistente.setAutor(autor);
            libroExistente.setEjemplares(ejemplares);
            libroDao.actualizarLibro(libroExistente);
        }
    }

    public void eliminarLibro(int codigo) {
        Libro libroExistente = libroDao.obtenerLibroPorCodigo(codigo);
        if (libroExistente != null) {
            libroDao.eliminarLibro(libroExistente);
        }
    }
}

