package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "conta_corrente")
@PrimaryKeyJoinColumns(value = {
    @PrimaryKeyJoinColumn(name = "numero", referencedColumnName = "numero"),
    @PrimaryKeyJoinColumn(name = "agencia", referencedColumnName = "agencia")
})
@DiscriminatorValue(value = "CONTA_CORRENTE")
@NamedQueries(value = {
    @NamedQuery(name = "ContaCorrente.SomaSaldos", query = "SELECT SUM(cr.saldo) FROM ContaCorrente cr")
})
public class ContaCorrente extends Conta {
    @Column(name = "tarifa")
    private double tarifa;

    public ContaCorrente() {
    }

    public ContaCorrente(double tarifa, double saldo, Cliente cliente) {
        super(saldo, cliente);
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
}
