package uniandes.edu.co.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Operacion_Prestamo;
import uniandes.edu.co.proyecto.repositorio.Operacion_PrestamoRepository;

@Controller
public class Operacion_PrestamoController {

    @Autowired
    Operacion_PrestamoRepository operacion_PrestamoRepository;

    @GetMapping("/operaciones_prestamos")
    public String operaciones_prestamos(Model model) {
        model.addAttribute("operaciones_prestamos", operacion_PrestamoRepository.darOperaciones_Prestamos());
        return "operaciones_prestamos";
    }

    @GetMapping("/operaciones_prestamos/new")
    public String operacion_prestamosForm(Model model){
        model.addAttribute("operacion_prestamo", new Operacion_Prestamo());
        return "operacion_prestamoNueva";
    }

    @PostMapping("/operaciones_prestamos/new/save")
    public String operacion_prestamoGuardar(@ModelAttribute Operacion_Prestamo operacion_Prestamo){
        operacion_PrestamoRepository.insertarOperacion_Prestamo(operacion_Prestamo.getMonto(), operacion_Prestamo.getHora(), operacion_Prestamo.getFecha(), operacion_Prestamo.getTipo_operacion_prestamo(), operacion_Prestamo.getPrestamo(), operacion_Prestamo.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), operacion_Prestamo.getEmpleadoCreador().getEmpleadoPK().getNum_doc(), operacion_Prestamo.getCliente().getClientePK().getTipo_doc(), operacion_Prestamo.getCliente().getClientePK().getNum_doc(), operacion_Prestamo.getPunto_atencion());
        return "redirect:/operaciones_prestamos";
    }

    @GetMapping("/operaciones_prestamos/{id}/edit")
    public String operacion_prestamoEditarForm(@PathVariable("id") Integer id, Model model){
        Operacion_Prestamo operacion_Prestamo = operacion_PrestamoRepository.darOperacion_Prestamo(id);
        if(operacion_Prestamo != null){
            model.addAttribute("operacion_prestamo", operacion_Prestamo);
            return "operacion_prestamoEditar";
        } else {
            return "redirect:/operaciones_prestamo";
        }
    }

    @PostMapping("/operaciones_prestamos/{id}/edit/save")
    public String operacion_prestamoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Operacion_Prestamo operacion_Prestamo) {
        operacion_PrestamoRepository.actualizarOperacion_Prestamo(id, operacion_Prestamo.getMonto(), operacion_Prestamo.getHora(), operacion_Prestamo.getFecha(), operacion_Prestamo.getTipo_operacion_prestamo(), operacion_Prestamo.getPrestamo(), operacion_Prestamo.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), operacion_Prestamo.getEmpleadoCreador().getEmpleadoPK().getNum_doc(), operacion_Prestamo.getCliente().getClientePK().getTipo_doc(), operacion_Prestamo.getCliente().getClientePK().getNum_doc(), operacion_Prestamo.getPunto_atencion());
        return "redirect:/operaciones_prestamos";
    }

    @GetMapping("/operaciones_prestamos/{id}/delete")
    public String operacion_prestamoEliminar(@PathVariable("id") Integer id){
        operacion_PrestamoRepository.eliminarOperacion_Prestamo(id);
        return "redirect:/operaciones_prestamos";
    }
}