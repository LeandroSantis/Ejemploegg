package ProyectoEgg.ProyectoEgg.Servicios;


import ProyectoEgg.ProyectoEgg.Entidades.Editorial;
import ProyectoEgg.ProyectoEgg.Repositorio.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServicio {
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre){

        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);
        editorial.setAlta(true);

        editorialRepositorio.save(editorial);
    }
    @Transactional
    public Editorial buscarEditorialId(String id){

        Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);

        return editorialOptional.orElse(null);
    }

    @Transactional
    public void modificarEditor(String id, String nombre){
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);

        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);



    }

    @Transactional
    public List<Editorial> buscarEditoriales(){
        return editorialRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public void eliminarEditorial(String id){
        editorialRepositorio.deleteById(id);
    }

    @Transactional
    public void alta(String id){
        editorialRepositorio.darDeAlta(id);
    }
}
