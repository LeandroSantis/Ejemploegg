package ProyectoEgg.ProyectoEgg.Controladores;

import ProyectoEgg.ProyectoEgg.Entidades.Autor;
import ProyectoEgg.ProyectoEgg.Servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorControlador {
    @Autowired
    private AutorServicio autorServicio;

    @GetMapping
    public ModelAndView mostrarAutores(){
        ModelAndView mav = new ModelAndView("autores");
        List<Autor> autores = autorServicio.buscarAutores();
        mav.addObject("autores", autorServicio.buscarAutores());
        return mav;
    }
    @GetMapping("/crear")
    public ModelAndView crearAutor() {
        ModelAndView mav = new ModelAndView("autor-formulario");
        mav.addObject("autor", new Autor());
        mav.addObject("title", "Crear Autor");
        mav.addObject("action", "guardar");
        return mav;
    }
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("autor-formulario");
        mav.addObject("autor", autorServicio.buscarAutorId(id));
        mav.addObject("action", "modificar");
        return mav;
    }
    @GetMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        autorServicio.eliminarAutor(id);
        return new RedirectView("/autores");
    }
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String nombre){

        autorServicio.crearAutor(nombre);

        return new RedirectView("/autores");
    }
    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam String nombre){
        autorServicio.modificarAutor(id,nombre);
        return new RedirectView("/autores");

    }

}
