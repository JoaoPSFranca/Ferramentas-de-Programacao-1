package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conta_especial")
@PrimaryKeyJoinColumn(name = "codigo_conta")
@DiscriminatorValue(value = "CONTA_ESPECIAL")
@NamedQueries(value = {
    @NamedQuery(name = "ContaEspecial.buscarContasNoVermelho", query = "FROM ContaEspecial ce WHERE ce.saldo <= 0"),
    @NamedQuery(name = "ContaEspecial.buscarMaiorSaldo", query = "SELECT MAX(ce.saldo) FROM ContaEspecial ce")
})
public class ContaEspecial extends Conta {
    @Column(name = "limite")
    private double limite;

    public ContaEspecial() {
    }

    public ContaEspecial(double limite, double saldo, Cliente cliente) {
        super(saldo, cliente);
        this.limite = limite;
    }
    
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
