package br.edu.ifsp.pep;

import br.edu.ifsp.pep.modelo.Pessoa;
import br.edu.ifsp.pep.modelo.PessoaStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    // O cara que permite fazer as coisas
    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("conexaoPU");
    
    public static void main(String[] args) {
        adicionar();
        alterar();
    }
    
    private static void adicionar(){
        Pessoa p1 = new Pessoa(
            1, "123.456.789-00",
            "César", 
            PessoaStatus.Ativa, 
            15000.59, 
            new BigDecimal(200.897), 
            new Date(), 
            LocalDate.now(), 
            LocalDateTime.now());
        
        Pessoa p2 = new Pessoa(
            2, "987.654.321-00", 
            "Ana", 
            PessoaStatus.Inativa, 
            15000.59, 
            new BigDecimal(200.891), 
            new Date(), 
            LocalDate.now(), 
            LocalDateTime.now());
        
        // Gerencia a entidade (crud e tal)
        EntityManager em = enf.createEntityManager();
        
        // Conexao.open()
        em.getTransaction().begin();
        
        // Insert p no bd
        em.persist(p1);
        em.persist(p2);
        
        // salva a ação
        em.getTransaction().commit();
        em.close();
    }
    
    private static void alterar() {
        EntityManager em = enf.createEntityManager();
        
        //Alteração
        Pessoa p1 = em.find(Pessoa.class, 1);
        p1.setNome("João");

        em.getTransaction().begin();
        em.merge(p1); // altera ou cria algo, se o objeto existe ele altera, se não ele cria
        em.getTransaction().commit();
        
        // conexao.close()
        em.close();
    }
}
