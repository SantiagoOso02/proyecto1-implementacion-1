package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

    @EmbeddedId
    private EmpleadoPK empleadoPK;

    private String tipo_empleado;

    private String nombre;
    private String nacionalidad;
    private String telefono;
    private String login;
    private String clave;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DIRECCION", referencedColumnName = "ID")
    private Direccion direccion;
    
    @ManyToOne
    @JoinColumn(name = "PUNTO_ATENCION", referencedColumnName = "ID")
    private Punto_Atencion punto_atencion;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOC_EMPLEADO_CREADOR", referencedColumnName = "TIPO_DOC"),
        @JoinColumn(name = "NUM_DOC_EMPLEADO_CREADOR", referencedColumnName = "NUM_DOC")
    })
    private Empleado empleadoCreador;


    public Empleado() {
        ;
    }

    public Empleado(EmpleadoPK empleadoPK, String tipo_empleado, String nombre, String nacionalidad, String telefono,
            String login, String clave, Direccion direccion, Empleado empleadoCreador, Punto_Atencion punto_atencion) {
        this.empleadoPK = empleadoPK;
        this.tipo_empleado = tipo_empleado;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.login = login;
        this.clave = clave;
        this.direccion = direccion;
        this.empleadoCreador = empleadoCreador;
        this.punto_atencion = punto_atencion;
    }

    public EmpleadoPK getEmpleadoPK() {
        return empleadoPK;
    }

    public void setEmpleadoPK(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Empleado getEmpleadoCreador() {
        return empleadoCreador;
    }

    public void setEmpleadoCreador(Empleado empleadoCreador) {
        this.empleadoCreador = empleadoCreador;
    }

    public Punto_Atencion getPunto_atencion() {
        return punto_atencion;
    }

    public void setPunto_atencion(Punto_Atencion punto_atencion) {
        this.punto_atencion = punto_atencion;
    }

    


    

}
