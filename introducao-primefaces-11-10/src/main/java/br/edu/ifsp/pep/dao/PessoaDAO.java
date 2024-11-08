package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.NivelAcesso;
import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa> {
    public Pessoa autenticar(String login, String senha) {
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.autenticar", Pessoa.class);
        query.setParameter("login", login.toLowerCase());
        query.setParameter("senha", senha);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Pessoa autenticarLogin(String login) {
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarLogin", Pessoa.class);
        query.setParameter("login", login.toLowerCase());
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Pessoa> buscarTodas() {
        return em.createNamedQuery("Pessoa.buscarTodas", Pessoa.class)
                .getResultList();
    }
    
    public List<Pessoa> buscarFinanceiro(){
        
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarFinanceiro", Pessoa.class);
        query.setParameter("nivelAcesso", NivelAcesso.Financeiro);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
