package uniandes.edu.co.proyecto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BancoController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}