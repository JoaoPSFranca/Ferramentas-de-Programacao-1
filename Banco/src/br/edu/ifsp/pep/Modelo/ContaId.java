package br.edu.ifsp.pep.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContaId implements Serializable {
    
    @Column(name = "numero", nullable = false)
    private int numero;
    
    @Column(name = "agencia", nullable = false)
    private int agencia;

    public ContaId() {
    }

    public ContaId(int numero, int agencia) {
        this.numero = numero;
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
}
