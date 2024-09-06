package br.edu.ifsp.pep;

import br.edu.ifsp.pep.modelo.Proprietario;
import br.edu.ifsp.pep.modelo.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    // O cara que permite fazer as coisas
    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("conexaoPU");
    
    public static void main(String[] args) {
        adicionar();
    }
    
    public static void adicionar(){
       Proprietario proprietario = new Proprietario();
       proprietario.setNome("João");
       proprietario.setEmail("Jota@gmail.com");
       proprietario.setTelefone("(13) 91234-1234");
       
       Veiculo veiculo = new Veiculo();
       veiculo.setAno(2000);
       veiculo.setFabricante("KIA");
       veiculo.setProprietario(proprietario);
       
       EntityManager em = enf.createEntityManager();
       
       em.getTransaction().begin();
       em.persist(veiculo);
       
       em.getTransaction().commit();
       em.close();
    }
}
