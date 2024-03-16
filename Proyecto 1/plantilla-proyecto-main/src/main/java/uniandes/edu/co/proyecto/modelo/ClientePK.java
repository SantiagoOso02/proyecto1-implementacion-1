package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;


@Embeddable
public class ClientePK implements Serializable{
    
    private String tipo_doc;
    private String num_doc;

    public ClientePK() {
        super();
    }

    public ClientePK(String tipo_doc, String num_doc) {
        super();
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setTipo_doc(String tipoDoc) {
        this.tipo_doc = tipoDoc;
    }

    public void setNum_doc(String numDoc) {
        this.num_doc = numDoc;
    }

    
    
}
