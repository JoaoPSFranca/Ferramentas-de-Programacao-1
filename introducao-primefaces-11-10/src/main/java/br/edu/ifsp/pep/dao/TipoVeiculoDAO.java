package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.TipoVeiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;
import java.util.List;

@Stateless
public class TipoVeiculoDAO extends AbstractDAO<TipoVeiculo> {

    public List<TipoVeiculo> buscarTodos() {
        try{
            return em.createNamedQuery("TipoVeiculo.buscarTodos", TipoVeiculo.class).getResultList();
        } catch (NoResultException e){
            return null;
        }
    }

    public TipoVeiculo buscarPeloCodigo(Long codigo) {
        System.out.println("Código: " + codigo);
        return em.find(TipoVeiculo.class, codigo);
    }

}
