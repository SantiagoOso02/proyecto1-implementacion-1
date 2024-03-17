package uniandes.edu.co.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.EmpleadoPK;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    private EmpleadoPK empleadoPK;

    @GetMapping("/empleado")
    public String empleados(Model model) {
        model.addAttribute("empleados", empleadoRepository.darEmpleados());
        return model.toString();
    }

    @GetMapping("/empleado/new")
    public String empleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleadoNuevo";
    }

    @PostMapping("/empleado/new/save")
    public String empleadoGuardar(@ModelAttribute Empleado empleado) {
        empleadoRepository.insertarEmpleado(empleadoPK.getTipo_doc(), empleadoPK.getNum_doc(), empleado.getTipo_empleado(), empleado.getNombre(), empleado.getNacionalidad(), 
        empleado.getTelefono(), empleado.getLogin(), empleado.getClave(), empleado.getDireccion().getId(), empleado.getPunto_atencion().getId(),
         empleado.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), empleado.getEmpleadoCreador().getEmpleadoPK().getNum_doc());
        return "redirect:/empleado";
    }


    @GetMapping("/empleado/{tipoDoc}/{numDoc}/edit")
    public String empleadoEditarForm(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") String numDoc, Model model) {
        EmpleadoPK empleadoPK = new EmpleadoPK(tipoDoc, numDoc);
        Empleado empleado = empleadoRepository.findById(empleadoPK).orElse(null);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "empleadoEditar";
        } else {
            return "redirect:/empleado";
        }
    }

    @PostMapping("/empleado/{tipoDoc}/{numDoc}/edit/save")
    public String empleadoEditarGuardar(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") String numDoc, @ModelAttribute Empleado empleado) {
        EmpleadoPK empleadoPK = new EmpleadoPK(tipoDoc, numDoc);
        empleado.setEmpleadoPK(empleadoPK);
        empleadoRepository.save(empleado);
        return "redirect:/empleado";
    }

    @GetMapping("/empleado/{tipoDoc}/{numDoc}/delete")
    public String empleadoEliminar(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") String numDoc) {
        EmpleadoPK empleadoPK = new EmpleadoPK(tipoDoc, numDoc);
        empleadoRepository.deleteById(empleadoPK);
        return "redirect:/empleado";
    }
    










}