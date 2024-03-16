package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String direccion_fisica;
    private String direccion_electronica;
    private String ciudad;
    private String departamento;
    private String codigo_postal;

    public Direccion() {
        ;
    }
    
    public Direccion(String direccion_fisica, String direccion_electronica, String ciudad, String departamento, String codigo_postal) {
        this.direccion_fisica = direccion_fisica;
        this.direccion_electronica = direccion_electronica;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigo_postal = codigo_postal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion_fisica() {
        return direccion_fisica;
    }

    public void setDireccion_fisica(String direccion_fisica) {
        this.direccion_fisica = direccion_fisica;
    }

    public String getDireccion_electronica() {
        return direccion_electronica;
    }

    public void setDireccion_electronica(String direccion_electronica) {
        this.direccion_electronica = direccion_electronica;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    
    
}
