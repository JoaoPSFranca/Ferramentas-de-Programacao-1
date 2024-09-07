package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conta_especial")
@PrimaryKeyJoinColumn(name = "codigo_conta")
@DiscriminatorValue(value = "CONTA_ESPECIAL")
public class ContaEspecial extends Conta {
    @Column(name = "limite")
    private double limite;

    public ContaEspecial() {
    }

    public ContaEspecial(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
