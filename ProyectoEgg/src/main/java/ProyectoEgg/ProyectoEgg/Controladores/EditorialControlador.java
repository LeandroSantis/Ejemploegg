package ProyectoEgg.ProyectoEgg.Controladores;

import ProyectoEgg.ProyectoEgg.Entidades.Editorial;
import ProyectoEgg.ProyectoEgg.Servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/editoriales")
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping
    public ModelAndView mostrarEditoriales(){
        ModelAndView mav = new ModelAndView("editoriales");
        List<Editorial> editoriales = editorialServicio.buscarEditoriales();
        mav.addObject("editoriales", editorialServicio.buscarEditoriales());
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crearEditorial() {
        ModelAndView mav = new ModelAndView("editorial-formulario");
        mav.addObject("editorial", new Editorial());
        mav.addObject("title", "Crear Editorial");
        mav.addObject("action", "guardar");
        return mav;
    }
    @GetMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        editorialServicio.eliminarEditorial(id);
        return new RedirectView("/editoriales");
    }
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String nombre){

        editorialServicio.crearEditorial(nombre);

        return new RedirectView("/editoriales");
    }

    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam String nombre){
        editorialServicio.modificarEditor(id, nombre);
        return new RedirectView("/editoriales");

    }

}
