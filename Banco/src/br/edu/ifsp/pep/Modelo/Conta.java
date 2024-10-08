package br.edu.ifsp.pep.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries (value = {
    @NamedQuery(name = "Conta.buscarSaldoZeroOuMenor", query = "FROM Conta c WHERE c.saldo <= 0")
})
@DiscriminatorColumn(name = "Type", discriminatorType = DiscriminatorType.STRING)
public class Conta implements Serializable {
    
    @EmbeddedId
    private ContaId codigo;
    
    @Column(name = "saldo", nullable = false)
    private double saldo;
    
    @ManyToOne
    @JoinColumn(name = "cliente_codigo", nullable = false)
    private Cliente cliente;

    public Conta() {
    }

    public Conta(double saldo, Cliente cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public ContaId getCodigo() {
        return codigo;
    }

    public void setCodigo(ContaId codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
