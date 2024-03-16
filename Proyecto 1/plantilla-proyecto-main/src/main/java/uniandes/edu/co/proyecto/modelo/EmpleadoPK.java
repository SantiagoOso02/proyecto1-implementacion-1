package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmpleadoPK {

    private String tipo_doc;
    private String num_doc;

    public EmpleadoPK() {
        super();
    }

    public EmpleadoPK(String tipo_doc, String num_doc) {
        super();
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    
    
}
