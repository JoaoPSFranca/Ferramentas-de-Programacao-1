package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {
    
    @EmbeddedId
    private VeiculoId codigo;
    
    @Column(name = "fabricante")
    private String fabricante;
    
    @Column(name = "ano")
    private int ano;

    public Veiculo() {
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

    public VeiculoId getCodigo() {
        return codigo;
    }

    public void setCodigo(VeiculoId codigo) {
        this.codigo = codigo;
    }
}
