package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conta_poupanca")
@PrimaryKeyJoinColumn(name = "codigo_conta")
@DiscriminatorValue(value = "CONTA_POUPANCA")
public class ContaPoupanca extends Conta{
    @Column(name = "aniversario")
    private int aniversario;

    public ContaPoupanca() {
    }

    public ContaPoupanca(int aniversario) {
        this.aniversario = aniversario;
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }
}
