package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo_prestamo;

    private String estado;

    private Integer monto;
    
    private Integer interes;

    private Integer numero_cuotas;

    private Integer dia_mes;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOC_CLIENTE", referencedColumnName = "TIPO_DOC"),
        @JoinColumn(name = "NUM_DOC_CLIENTE", referencedColumnName = "NUM_DOC")
    })
    private Cliente cliente;

    public Prestamo() {
        ;
    }

    public Prestamo(Integer id, String tipo_prestamo, String estado, Integer monto, Integer interes, Integer numero_cuotas, Integer dia_mes, Cliente cliente) {
        this.id = id;
        this.tipo_prestamo = tipo_prestamo;
        this.estado = estado;
        this.monto = monto;
        this.interes = interes;
        this.numero_cuotas = numero_cuotas;
        this.dia_mes = dia_mes;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_prestamo() {
        return tipo_prestamo;
    }

    public void setTipo_prestamo(String tipo_prestamo) {
        this.tipo_prestamo = tipo_prestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getInteres() {
        return interes;
    }

    public void setInteres(Integer interes) {
        this.interes = interes;
    }

    public Integer getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(Integer numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }

    public Integer getDia_mes() {
        return dia_mes;
    }

    public void setDia_mes(Integer dia_mes) {
        this.dia_mes = dia_mes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
