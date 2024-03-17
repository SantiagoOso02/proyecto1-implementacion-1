package uniandes.edu.co.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.repositorio.DireccionRepository;

@RestController
public class DireccionController {

    @Autowired
    private DireccionRepository direccionRepository;

    @GetMapping("/direccion")
    public String direccion(Model model) {
        model.addAttribute("direcciones", direccionRepository.darDireccion());
        return model.toString();
    }

    @GetMapping("/direccion/new")
    public String direccionForm(Model model) {
        model.addAttribute(model.addAttribute("direccion", new Direccion()));
        return "direccionNuevo";
    }
    
    @PostMapping("/direccion/new/save")
    public String direccionGuardar(@ModelAttribute Direccion direccion) {
        direccionRepository.insertarDireccion(direccion.getDireccion_fisica(),direccion.getDireccion_electronica(), direccion.getCiudad(), direccion.getDepartamento(), direccion.getCodigo_postal());
        
        return "redirect:/direccion";
    }

    @GetMapping("/direccion/{id}/edit")
    public String direccionEditarForm(@PathVariable("id") int id, Model model) {
        Direccion direccion = direccionRepository.darDireccionPorId(id);
        if(direccion != null){
            model.addAttribute("direccion", direccion);
            return "direccionEditar";
        }else{
            return "redirect:/direccion";
        }
       
    }

    @PostMapping("/direccion/{id}/edit/save")
    public String direccionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Direccion direccion) {
        direccionRepository.actualizarDireccion(id, direccion.getDireccion_fisica(),direccion.getDireccion_electronica(), 
        direccion.getCiudad(), direccion.getDepartamento(), direccion.getCodigo_postal());
        return "redirect:/direccion";
    }

    @GetMapping("/direccion/{id}/delete")
    public String direccionEliminar(@PathVariable("id") int id) {
        direccionRepository.eliminarDireccion(id);
        return "redirect:/direccion";
    }
    






















}
