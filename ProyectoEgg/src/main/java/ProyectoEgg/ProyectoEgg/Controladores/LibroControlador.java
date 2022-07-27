package ProyectoEgg.ProyectoEgg.Controladores;

import ProyectoEgg.ProyectoEgg.Entidades.Autor;
import ProyectoEgg.ProyectoEgg.Entidades.Editorial;
import ProyectoEgg.ProyectoEgg.Entidades.Libro;
import ProyectoEgg.ProyectoEgg.Servicios.AutorServicio;
import ProyectoEgg.ProyectoEgg.Servicios.EditorialServicio;
import ProyectoEgg.ProyectoEgg.Servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping()
    public ModelAndView mostrarLibros(){
        ModelAndView mav = new ModelAndView("libros");
        List<Libro> libros = libroServicio.buscarLibros();
        mav.addObject("libros", libroServicio.buscarLibros());

        return mav;
    }
    @GetMapping("/crear")
    public ModelAndView crearLibro() {
        ModelAndView mav = new ModelAndView("libro-formulario");
        mav.addObject("libro", new Libro());
        mav.addObject("autores", autorServicio.buscarAutores());
        mav.addObject("editoriales", editorialServicio.buscarEditoriales());
        mav.addObject("title", "Crear Libro");
        mav.addObject("action", "guardar");
        return mav;
    }
    @GetMapping("/editar/{id}")
    public ModelAndView editarLibro(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("libro-formulario");
        mav.addObject("libro", libroServicio.buscarLibroId(id));
        mav.addObject("autores", autorServicio.buscarAutores());
        mav.addObject("editoriales", editorialServicio.buscarEditoriales());
        mav.addObject("title", "Editar Libro");
        mav.addObject("action", "modificar");
        return mav;
    }
    @GetMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        libroServicio.eliminarLibro(id);
        return new RedirectView("/libros");
    }

    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ejemplaresPrestados, @RequestParam Integer ejemplaresRestantes, @RequestParam Autor autor, @RequestParam Editorial editorial) {

        libroServicio.modificarLibro(id, isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, autor, editorial);

        return new RedirectView("/libros");
    }
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ejemplaresPrestados, @RequestParam Integer ejemplaresRestantes, @RequestParam Autor autor, @RequestParam Editorial editorial){

        libroServicio.crearLibro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, autor, editorial);

        return new RedirectView("/libros");
    }




}
