package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conta_poupanca")
@PrimaryKeyJoinColumn(name = "codigo_conta")
@DiscriminatorValue(value = "CONTA_POUPANCA")
@NamedQueries(value = {
    @NamedQuery(name = "ContaPoupanca.buscarPeloAniversario", query = "FROM ContaPoupanca cp WHERE cp.aniversario = :aniversario")
})
public class ContaPoupanca extends Conta{
    @Column(name = "aniversario")
    private int aniversario;

    public ContaPoupanca() {
    }

    public ContaPoupanca(int aniversario, double saldo, Cliente cliente) {
        super(saldo, cliente);
        this.aniversario = aniversario;
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }
}
