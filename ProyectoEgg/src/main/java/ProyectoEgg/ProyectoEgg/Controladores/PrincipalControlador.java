package ProyectoEgg.ProyectoEgg.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class PrincipalControlador {

    @GetMapping("/index")
    public ModelAndView inicio(HttpSession session) {
        return new ModelAndView("index");
    }


}
