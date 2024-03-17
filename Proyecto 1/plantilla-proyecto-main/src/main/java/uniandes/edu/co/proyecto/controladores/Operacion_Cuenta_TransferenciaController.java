package uniandes.edu.co.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta_Transferencia;
import uniandes.edu.co.proyecto.repositorio.Operacion_Cuenta_TransferenciaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Operacion_Cuenta_TransferenciaController {

    @Autowired
    Operacion_Cuenta_TransferenciaRepository operacion_Cuenta_TransferenciaRepository;

    @GetMapping("/operaciones_cuentas_transferencias")
    public String operaciones_cuentas_transferencias(Model model) {
        model.addAttribute("operaciones_cuentas_transferencias", operacion_Cuenta_TransferenciaRepository.darOperaciones_Cuentas_Transferencias());
        return "operaciones_cuentas_transferencias";
    }

    @GetMapping("/operaciones_cuentas_transferencias/new")
    public String operacion_cuenta_transferenciaForm(Model model){
        model.addAttribute("operacion_cuenta_transferencia", new Operacion_Cuenta_Transferencia());
        return "operacion_cuenta_transferenciaNueva";
    }

    @PostMapping("/operaciones_cuentas_transferencias/new/save")
    public String operacion_cuenta_transferenciaGuardar(@ModelAttribute Operacion_Cuenta_Transferencia operacion_Cuenta_Transferencia){
        operacion_Cuenta_TransferenciaRepository.insertarOperacion_Cuenta_Transferencia(operacion_Cuenta_Transferencia.getMonto(), operacion_Cuenta_Transferencia.getHora(), operacion_Cuenta_Transferencia.getFecha(), operacion_Cuenta_Transferencia.getTipo(), operacion_Cuenta_Transferencia.getNumero_cuenta_origen(), operacion_Cuenta_Transferencia.getNumero_cuenta_destino(), operacion_Cuenta_Transferencia.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), operacion_Cuenta_Transferencia.getEmpleadoCreador().getEmpleadoPK().getNum_doc(), operacion_Cuenta_Transferencia.getCliente().getClientePK().getTipo_doc(), operacion_Cuenta_Transferencia.getCliente().getClientePK().getNum_doc(), operacion_Cuenta_Transferencia.getPunto_atencion());
        return "redirect:/operaciones_cuentas_transferencias";
    }

    @GetMapping("/operaciones_cuentas_transferencias/{id}/edit")
    public String operacion_cuenta_transferenciaEditarForm(@PathVariable("id") Integer id, Model model){
        Operacion_Cuenta_Transferencia operacion_Cuenta_Transferencia = operacion_Cuenta_TransferenciaRepository.darOperacion_Cuenta_Transferencia(id);
        if(operacion_Cuenta_Transferencia != null){
            model.addAttribute("operacion_cuenta_transferencia", operacion_Cuenta_Transferencia);
            return "operacion_cuenta_transferenciaEditar";
        } else {
            return "redirect:/operaciones_cuentas_transferencias";
        }
    }

    @PostMapping("/operaciones_cuentas_transferencias/{id}/edit/save")
    public String operacion_cuenta_transferenciaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Operacion_Cuenta_Transferencia operacion_Cuenta_Transferencia) {
        operacion_Cuenta_TransferenciaRepository.actualizarOperacion_Cuenta_Transferencia(id, operacion_Cuenta_Transferencia.getMonto(), operacion_Cuenta_Transferencia.getHora(), operacion_Cuenta_Transferencia.getFecha(), operacion_Cuenta_Transferencia.getTipo(), operacion_Cuenta_Transferencia.getNumero_cuenta_origen(), operacion_Cuenta_Transferencia.getNumero_cuenta_destino(), operacion_Cuenta_Transferencia.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), operacion_Cuenta_Transferencia.getEmpleadoCreador().getEmpleadoPK().getNum_doc(), operacion_Cuenta_Transferencia.getCliente().getClientePK().getTipo_doc(), operacion_Cuenta_Transferencia.getCliente().getClientePK().getNum_doc(), operacion_Cuenta_Transferencia.getPunto_atencion());
        return "redirect:/operaciones_cuentas_transferencias";
    }

    @GetMapping("/operaciones_cuentas_transferencias/{id}/delete")
    public String operacion_cuenta_transferenciaEliminar(@PathVariable("id") Integer id){
        operacion_Cuenta_TransferenciaRepository.eliminarOperacion_Cuenta_Transferencia(id);
        return "redirect:/operaciones_cuentas_transferencias";
    }
}