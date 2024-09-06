package br.edu.ifsp.pep.Modelo;

import br.edu.ifsp.pep.Modelo.ProdutoStatus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "nome", unique = true)
    private String nome;
    
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProdutoStatus status;
    
    @Column(name = "valor")
    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ProdutoStatus getStatus() {
        return status;
    }

    public void setStatus(ProdutoStatus status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto() {
    
    }
    
    public Produto(String nome, Date dataCadastro, ProdutoStatus status, double valor) {
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.valor = valor;
    }
}
