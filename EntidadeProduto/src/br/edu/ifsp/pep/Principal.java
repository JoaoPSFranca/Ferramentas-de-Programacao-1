package br.edu.ifsp.pep;

import br.edu.ifsp.pep.Modelo.Produto;
import br.edu.ifsp.pep.Modelo.ProdutoStatus;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("ConexaoPU");
    
    public static void main(String[] args) {
        Produto p1 = new Produto("Coca", new Date(), ProdutoStatus.EmEstoque, 15.00);
        Produto p2 = new Produto("Bala", new Date(), ProdutoStatus.Esgotado, 0.50);
        Produto p3 = new Produto("Paçoca", new Date(), ProdutoStatus.EmEstoque, 1.00);
        Produto p4 = new Produto("Salgado", new Date(), ProdutoStatus.Esgotado, 5.00);
        Produto p5 = new Produto("Doce", new Date(), ProdutoStatus.EmEstoque, 5.00);
        
        adicionar(p1);
        adicionar(p2);
        adicionar(p3);
        adicionar(p4);
        adicionar(p5);
    }
    
    private static void adicionar(Produto p1){
        EntityManager em = enf.createEntityManager();
        
        // Conexao.open()
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        em.close();
    }
}
