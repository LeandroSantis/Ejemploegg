package ProyectoEgg.ProyectoEgg.Servicios;

import ProyectoEgg.ProyectoEgg.Entidades.Autor;
import ProyectoEgg.ProyectoEgg.Repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre){

        Autor autor = new Autor();

        autor.setNombre(nombre);
        autor.setAlta(true);
        autorRepositorio.save(autor);

    }

    @Transactional(readOnly = true)
    public Autor buscarAutorId(String id){

        Optional<Autor> autorOptional = autorRepositorio.findById(id);
        return autorOptional.orElse(null);
    }

    @Transactional
    public void modificarAutor(String id, String nombre){
        Autor autor = autorRepositorio.findById(id).orElse(null);


        autor.setNombre(nombre);

        autorRepositorio.save(autor);
    }

    @Transactional(readOnly = true)
    public List<Autor> buscarAutores(){
        return autorRepositorio.findAll();
    }

    @Transactional
    public void eliminarAutor(String id){
        autorRepositorio.deleteById(id);
    }

    @Transactional
    public void alta(String id){
        autorRepositorio.darDeAlta(id);
    }
}
