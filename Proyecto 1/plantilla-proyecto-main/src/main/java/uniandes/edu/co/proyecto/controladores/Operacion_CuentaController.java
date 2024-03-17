package uniandes.edu.co.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta;
import uniandes.edu.co.proyecto.repositorio.Operacion_CuentaRepository;

@Controller
public class Operacion_CuentaController {

    @Autowired
    Operacion_CuentaRepository operacion_CuentaRepository;

    @GetMapping("/operaciones_cuentas")
    public String operaciones_cuentas(Model model) {
        model.addAttribute("operaciones_cuentas", operacion_CuentaRepository.darOperaciones_Cuentas());
        return "operaciones_cuentas";
    }

    @GetMapping("/operaciones_cuentas/new")
    public String operacion_cuentaForm(Model model){
        model.addAttribute("operacion_cuenta", new Operacion_Cuenta());
        return "operacion_cuentaNueva";
    }

    @PostMapping("/operaciones_cuentas/new/save")
    public String operacion_cuentaGuardar(@ModelAttribute Operacion_Cuenta operacion_Cuenta){
        operacion_CuentaRepository.insertarOperacion_Cuenta(operacion_Cuenta.getMonto(), operacion_Cuenta.getHora(), operacion_Cuenta.getFecha(), operacion_Cuenta.getTipo_operacion_cuenta(), operacion_Cuenta.getNumero_cuenta(), operacion_Cuenta.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), operacion_Cuenta.getEmpleadoCreador().getEmpleadoPK().getNum_doc(), operacion_Cuenta.getCliente().getClientePK().getTipo_doc(), operacion_Cuenta.getCliente().getClientePK().getNum_doc(), operacion_Cuenta.getPunto_atencion());
        return "redirect:/operaciones_cuentas";
    }

    @GetMapping("/operaciones_cuentas/{id}/edit")
    public String operacion_cuentaEditarForm(@PathVariable("id") Integer id, Model model){
        Operacion_Cuenta operacion_Cuenta = operacion_CuentaRepository.darOperacion_Cuenta(id);
        if(operacion_Cuenta != null){
            model.addAttribute("operacion_cuenta", operacion_Cuenta);
            return "operacion_cuentaEditar";
        } else {
            return "redirect:/operaciones_cuentas";
        }
    }

    @PostMapping("/operaciones_cuentas/{id}/edit/save")
    public String operacion_cuentaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Operacion_Cuenta operacion_Cuenta) {
        operacion_CuentaRepository.actualizarOperacion_Cuenta(id, operacion_Cuenta.getMonto(), operacion_Cuenta.getHora(), operacion_Cuenta.getFecha(), operacion_Cuenta.getTipo_operacion_cuenta(), operacion_Cuenta.getNumero_cuenta(), operacion_Cuenta.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), operacion_Cuenta.getEmpleadoCreador().getEmpleadoPK().getNum_doc(), operacion_Cuenta.getCliente().getClientePK().getTipo_doc(), operacion_Cuenta.getCliente().getClientePK().getNum_doc(), operacion_Cuenta.getPunto_atencion());
        return "redirect:/operaciones_cuentas";
    }

    @GetMapping("/operaciones_cuentas/{id}/delete")
    public String operacion_cuentaEliminar(@PathVariable("id") Integer id){
        operacion_CuentaRepository.eliminarOperacion_Cuenta(id);
        return "redirect:/operaciones_cuentas";
    }
}