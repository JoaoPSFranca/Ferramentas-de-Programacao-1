package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "fabricante")
    private String fabricante;
    
    @ManyToMany
    @JoinTable(name = "acessorio_veiculo")
    private Set<Acessorio> acessorio;
    
    @Column(name = "ano")
    private int ano;

    public Veiculo() {
    }

    public Set<Acessorio> getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Set<Acessorio> acessorio) {
        this.acessorio = acessorio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
