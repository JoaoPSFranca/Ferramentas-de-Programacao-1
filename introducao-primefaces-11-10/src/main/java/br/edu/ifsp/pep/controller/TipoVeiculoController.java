package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.TipoVeiculoDAO;
import br.edu.ifsp.pep.entity.TipoVeiculo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class TipoVeiculoController implements Serializable {

    @Inject
    private TipoVeiculoDAO tipoVeiculoDAO;

    public TipoVeiculoController() {        
    }
    
    public List<TipoVeiculo> buscarTiposVeiculos() {
        List<TipoVeiculo> tipos = tipoVeiculoDAO.buscarTodos();
        
        System.out.println(tipos);
        
        if(tipos.isEmpty()){
            tipos = new ArrayList<>();
            
            TipoVeiculo tp = new TipoVeiculo("Caminhão");
            tipoVeiculoDAO.inserir(tp);
            tipos.add(tp);
            
            TipoVeiculo tp2 = new TipoVeiculo("Carro");
            tipoVeiculoDAO.inserir(tp2);
            tipos.add(tp2);
            
            TipoVeiculo tp3 = new TipoVeiculo("Trator");
            tipoVeiculoDAO.inserir(tp3);
            tipos.add(tp3);
        }
        
        return tipos;
    }    

}
