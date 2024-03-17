package uniandes.edu.co.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.ClientePK;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    private ClientePK clientePk;

    @GetMapping("/cliente")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        return model.toString();
    }

    @GetMapping("/cliente/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    } 

    @PostMapping("/cliente/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente) {
        clienteRepository.insertarCliente(clientePk.getTipo_doc(), clientePk.getNum_doc(), cliente.getTipo_cliente(), cliente.getNombre(), cliente.getNacionalidad(), 
        cliente.getTelefono(), cliente.getLogin(), cliente.getClave(), cliente.getDireccion().getId(), 
        cliente.getEmpleadoCreador().getEmpleadoPK().getTipo_doc(), cliente.getEmpleadoCreador().getEmpleadoPK().getNum_doc());
        return "redirect:/cliente"; 
    }



    @GetMapping("/cliente/{tipoDoc}/{numDoc}/edit")
    public String clienteEditarForm(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") String numDoc, Model model) {
        ClientePK clientePk = new ClientePK(tipoDoc, numDoc);
        Cliente cliente = clienteRepository.findById(clientePk).orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar"; 
        } else {
            return "redirect:/cliente";
        }
    }

    @PostMapping("/cliente/{tipoDoc}/{numDoc}/edit/save")
    public String clienteEditarGuardar(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") String numDoc, @ModelAttribute Cliente cliente) {
        ClientePK clientePk = new ClientePK(tipoDoc, numDoc);
        cliente.setClientePK(clientePk);
        clienteRepository.save(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/cliente/{tipoDoc}/{numDoc}/delete")
    public String clienteEliminar(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") String numDoc) {
        ClientePK clientePk = new ClientePK(tipoDoc, numDoc);
        clienteRepository.deleteById(clientePk);
        return "redirect:/cliente";
    }




    
}