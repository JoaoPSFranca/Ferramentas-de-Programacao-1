package br.edu.ifsp.pep.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa {
    
    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
