package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conta_corrente")
@PrimaryKeyJoinColumn(name = "codigo_conta")
@DiscriminatorValue(value = "CONTA_CORRENTE")
public class Conta_Corrente extends Conta {
    @Column(name = "tarifa")
    private double tarifa;

    public Conta_Corrente() {
    }

    public Conta_Corrente(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
}
