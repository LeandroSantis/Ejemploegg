package ProyectoEgg.ProyectoEgg.Servicios;


import ProyectoEgg.ProyectoEgg.Entidades.Autor;
import ProyectoEgg.ProyectoEgg.Entidades.Editorial;
import ProyectoEgg.ProyectoEgg.Entidades.Libro;
import ProyectoEgg.ProyectoEgg.Repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Autor autor, Editorial editorial){

        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libro.setAlta(true);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

    @Transactional(readOnly = true)
    public Libro buscarLibroId(String id){
        Optional<Libro> libroOptional = libroRepositorio.findById(id);
        return libroOptional.orElse(null);
    }

    @Transactional
    public void modificarLibro(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Autor autor, Editorial editorial){

        libroRepositorio.modificarLibro(id, isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, autor, editorial);

    }
    @Transactional(readOnly = true)
    public List<Libro> buscarLibros(){
        return libroRepositorio.findAll();
    }

    @Transactional
    public void eliminarLibro(String id) {
        libroRepositorio.deleteById(id);
    }

    @Transactional
    public void alta(String id) {
        libroRepositorio.darDeAlta(id);
    }

}
