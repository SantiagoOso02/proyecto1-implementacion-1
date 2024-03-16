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
@Table(name = "clientes")
public class Cliente {

    @EmbeddedId
    private ClientePK clientePK;

    private String tipo_cliente;

    private String nombre;
    
    private String nacionalidad;
    
    private String telefono; 

    private String login;

    private String clave;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DIRECCION", referencedColumnName = "ID")
    private Direccion direccion;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOC_EMPLEADO_CREADOR", referencedColumnName = "TIPO_DOC"),
        @JoinColumn(name = "NUM_DOC_EMPLEADO_CREADOR", referencedColumnName = "NUM_DOC")
    })
    private Empleado empleadoCreador;

    public Cliente() {
        ;
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
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

    

    
}
