package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="operaciones_cuenta")

public class Operacion_Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer ID;

    private String tipo_operacion_cuenta;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "NUMERO_CUENTA", referencedColumnName = "NUMERO_CUENTA")
    private Cuenta numero_cuenta;


    private Integer monto;

    private Date hora;

    private Date fecha;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOC_EMPLEADO", referencedColumnName = "TIPO_DOC"),
        @JoinColumn(name = "NUM_DOC_EMPLEADO", referencedColumnName = "NUM_DOC")
    })
    private Empleado empleadoCreador;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOC_CLIENTE", referencedColumnName = "TIPO_DOC"),
        @JoinColumn(name = "NUM_DOC_CLIENTE", referencedColumnName = "NUM_DOC")
    })
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PUNTO_ATENCION", referencedColumnName = "ID")
    private Punto_Atencion punto_atencion;


    public Operacion_Cuenta() {
        ;
    }

    public Operacion_Cuenta(Integer ID, String tipo_operacion_cuenta, Cuenta numero_cuenta, Integer monto, Date hora, Date fecha, Empleado empleadoCreador, Cliente cliente, Punto_Atencion punto_atencion) {
        this.ID = ID;
        this.tipo_operacion_cuenta = tipo_operacion_cuenta;
        this.numero_cuenta = numero_cuenta;
        this.monto = monto;
        this.hora = hora;
        this.fecha = fecha;
        this.empleadoCreador = empleadoCreador;
        this.cliente = cliente;
        this.punto_atencion = punto_atencion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getTipo_operacion_cuenta() {
        return tipo_operacion_cuenta;
    }

    public void setTipo_operacion_cuenta(String tipo_operacion_cuenta) {
        this.tipo_operacion_cuenta = tipo_operacion_cuenta;
    }

    public Cuenta getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(Cuenta numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleadoCreador() {
        return empleadoCreador;
    }

    public void setEmpleadoCreador(Empleado empleadoCreador) {
        this.empleadoCreador = empleadoCreador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Punto_Atencion getPunto_atencion() {
        return punto_atencion;
    }

    public void setPunto_atencion(Punto_Atencion punto_atencion) {
        this.punto_atencion = punto_atencion;
    }


    


}