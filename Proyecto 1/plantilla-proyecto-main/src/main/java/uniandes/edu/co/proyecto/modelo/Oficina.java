package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficinas")
public class Oficina {
    
    @Id
    private Integer id;
    
    private String nombre;
 
    @ManyToOne
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    private Direccion direccion;

    private Integer numero_puntos_atencion;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOC_EMPLEADO_GERENTE", referencedColumnName = "TIPO_DOC"),
        @JoinColumn(name = "NUM_DOC_EMPLEADO_GERENTE", referencedColumnName = "NUM_DOC")
    })
    private Empleado gerente;

    public Oficina() {
        ;
    }

    public Oficina(Integer id, String nombre, Direccion direccion, Integer numero_puntos_atencion, Empleado gerente) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero_puntos_atencion = numero_puntos_atencion;
        this.gerente = gerente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Integer getNumero_puntos_atencion() {
        return numero_puntos_atencion;
    }

    public void setNumero_puntos_atencion(Integer numero_puntos_atencion) {
        this.numero_puntos_atencion = numero_puntos_atencion;
    }

    public Empleado getGerente() {
        return gerente;
    }

    public void setGerente(Empleado gerente) {
        this.gerente = gerente;
    }
    

    




}
