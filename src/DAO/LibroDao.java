package DAO;


import model.Libro;
import java.util.List;

public interface LibroDao {
    List<Libro> listarLibros();
    Libro obtenerLibroPorCodigo(int codigo);
    void agregarLibro(Libro libro);
    void actualizarLibro(Libro libro);
    void eliminarLibro(Libro libro);
}

