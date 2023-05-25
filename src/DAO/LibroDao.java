package DAO;

import java.util.List;
import model.Libro;


public interface LibroDao {
    public List<Libro> getLibros();
    public Libro getLibro(int codigo, String autor);
    public boolean addLibro(Libro libros);
    public boolean updateLibro(int codigo, Libro libros);
    public boolean deleteLibro(int codigo, Libro libros);
}
