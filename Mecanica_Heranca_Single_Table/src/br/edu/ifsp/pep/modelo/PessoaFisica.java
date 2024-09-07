package br.edu.ifsp.pep.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PESSOA_FISICA")
public class PessoaFisica extends Pessoa {
    
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    public PessoaFisica() {
    }
    
    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}