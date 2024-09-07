package br.edu.ifsp.pep.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContaId implements Serializable {
    
    @Column(name = "numero", nullable = false)
    private String numero;
    
    @Column(name = "agencia", nullable = false)
    private String agencia;

    public ContaId() {
    }

    public ContaId(String numero, String agencia) {
        this.numero = numero;
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
