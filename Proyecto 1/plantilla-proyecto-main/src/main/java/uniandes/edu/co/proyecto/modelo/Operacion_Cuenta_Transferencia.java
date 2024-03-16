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
@Table(name="operaciones_cuenta_transferencia")

public class Operacion_Cuenta_Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer ID;
    private Integer monto;
    private Date hora;
    private Date fecha;
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "NUMERO_CUENTA_ORIGEN", referencedColumnName = "NUMERO_CUENTA")
    private Cuenta numero_cuenta_origen;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "NUMERO_CUENTA_DESTINO", referencedColumnName = "NUMERO_CUENTA")
    private Cuenta numero_cuenta_destino;

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

    public Operacion_Cuenta_Transferencia() {
        ;
    }

    public Operacion_Cuenta_Transferencia(Integer ID, Integer monto, Date hora, Date fecha, String tipo, Cuenta numero_cuenta_origen, Cuenta numero_cuenta_destino, Empleado empleadoCreador, Cliente cliente, Punto_Atencion punto_atencion) {
        this.ID = ID;
        this.monto = monto;
        this.hora = hora;
        this.fecha = fecha;
        this.tipo = tipo;
        this.numero_cuenta_origen = numero_cuenta_origen;
        this.numero_cuenta_destino = numero_cuenta_destino;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cuenta getNumero_cuenta_origen() {
        return numero_cuenta_origen;
    }

    public void setNumero_cuenta_origen(Cuenta numero_cuenta_origen) {
        this.numero_cuenta_origen = numero_cuenta_origen;
    }

    public Cuenta getNumero_cuenta_destino() {
        return numero_cuenta_destino;
    }

    public void setNumero_cuenta_destino(Cuenta numero_cuenta_destino) {
        this.numero_cuenta_destino = numero_cuenta_destino;
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