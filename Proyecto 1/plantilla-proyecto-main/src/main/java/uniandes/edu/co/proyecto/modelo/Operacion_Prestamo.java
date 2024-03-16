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
@Table(name="operaciones_prestamo")

public class Operacion_Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private String tipo_operacion_prestamo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRESTAMO", referencedColumnName = "ID")
    private Prestamo prestamo;


    private float monto;

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

    public Operacion_Prestamo() {
        ;
    }

    public Operacion_Prestamo(Integer ID, String tipo_operacion_prestamo, Prestamo prestamo, float monto, Date hora, Date fecha, Empleado empleadoCreador, Cliente cliente, Punto_Atencion punto_atencion) {
        this.ID = ID;
        this.tipo_operacion_prestamo = tipo_operacion_prestamo;
        this.prestamo = prestamo;
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

    public String getTipo_operacion_prestamo() {
        return tipo_operacion_prestamo;
    }

    public void setTipo_operacion_prestamo(String tipo_operacion_prestamo) {
        this.tipo_operacion_prestamo = tipo_operacion_prestamo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
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