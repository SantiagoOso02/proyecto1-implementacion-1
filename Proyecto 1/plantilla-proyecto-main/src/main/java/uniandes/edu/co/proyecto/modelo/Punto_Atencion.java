package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "puntos_atencion")
public class Punto_Atencion {
    
    @Id
    private Integer id;

    private String tipo_punto_atencion;

    private String localizacion_geografica;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOC_EMPLEADO_CREADOR", referencedColumnName = "TIPO_DOC"),
        @JoinColumn(name = "NUM_DOC_EMPLEADO_CREADOR", referencedColumnName = "NUM_DOC")
    })
    private Empleado empleadoCreador;

    @ManyToOne
    @JoinColumn(name = "oficina", referencedColumnName = "id")
    private Oficina oficina;

    public Punto_Atencion() {
        ;
    }

    public Punto_Atencion(Integer id, String tipo_punto_atencion, String localizacion_geografica, Empleado empleadoCreador, Oficina oficina) {
        this.id = id;
        this.tipo_punto_atencion = tipo_punto_atencion;
        this.localizacion_geografica = localizacion_geografica;
        this.empleadoCreador = empleadoCreador;
        this.oficina = oficina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_punto_atencion() {
        return tipo_punto_atencion;
    }

    public void setTipo_punto_atencion(String tipo_punto_atencion) {
        this.tipo_punto_atencion = tipo_punto_atencion;
    }

    public String getLocalizacion_geografica() {
        return localizacion_geografica;
    }

    public void setLocalizacion_geografica(String localizacion_geografica) {
        this.localizacion_geografica = localizacion_geografica;
    }

    public Empleado getEmpleadoCreador() {
        return empleadoCreador;
    }

    public void setEmpleadoCreador(Empleado empleadoCreador) {
        this.empleadoCreador = empleadoCreador;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    

}
