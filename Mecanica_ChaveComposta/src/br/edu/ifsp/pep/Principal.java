package br.edu.ifsp.pep;

//import br.edu.ifsp.pep.modelo.Proprietario;
import br.edu.ifsp.pep.modelo.Veiculo;
import br.edu.ifsp.pep.modelo.VeiculoId;
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
       Veiculo veiculo = new Veiculo();
       veiculo.setAno(2000);
       veiculo.setFabricante("KIA");
       VeiculoId vId = new VeiculoId("FDW-9457", "Santos");
       veiculo.setCodigo(vId);
       
       EntityManager em = enf.createEntityManager();
       
       em.getTransaction().begin();
       em.persist(veiculo);
       
       em.getTransaction().commit();
       em.close();
    }
}
