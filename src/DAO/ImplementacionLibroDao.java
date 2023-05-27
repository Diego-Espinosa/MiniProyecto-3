package DAO;

import model.Libro;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImplementacionLibroDao implements LibroDao {
    private Map<Integer, Libro> libros;

    public ImplementacionLibroDao() {
        this.libros = new HashMap<>();
    }

    @Override
    public List<Libro> listarLibros() {
        return libros.values().stream().collect(Collectors.toList());
    }

    @Override
    public Libro obtenerLibroPorCodigo(int codigo) {
        return libros.get(codigo);
    }

    @Override
    public void agregarLibro(Libro libro) {
        libros.put(libro.getCodigo(), libro);
    }

    @Override
    public void actualizarLibro(Libro libro) {
        if (libros.containsKey(libro.getCodigo())) {
            libros.put(libro.getCodigo(), libro);
        }
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libros.remove(libro.getCodigo());
    }
}
