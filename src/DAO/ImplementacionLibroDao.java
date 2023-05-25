package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.Libro;


public class ImplementacionLibroDao implements LibroDao{
    Map<Integer, Libro> LibroMap = new HashMap<>();

    @Override
    public List<Libro> getLibros() {
        List<Libro> Libros = new ArrayList<>();
        Iterator it = LibroMap.values().iterator();
        while (it.hasNext()) {
            Libros.add((Libro) it.next());
        }
        return Libros;
    }

    @Override
    public Libro getLibro(int codigo, String autor) {
        Libro libros = null;
        if (LibroMap.containsKey(codigo)) {
            libros = LibroMap.get(codigo);
        }
        return libros;
    }

    @Override
    public boolean addLibro(Libro libros) {
        LibroMap.put(libros.getCodigo(), libros);
        return true;
    }

    @Override
    public boolean updateLibro(int codigo, Libro libros) {
        if (LibroMap.containsKey(libros.getCodigo())) {
            LibroMap.put(libros.getCodigo(), libros);
        }
        return true;
    }

    @Override
    public boolean deleteLibro(int codigo, Libro libros) {
        LibroMap.remove(libros.getCodigo());
        return true;
    }
    
}
