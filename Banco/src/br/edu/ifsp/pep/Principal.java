package br.edu.ifsp.pep;

import br.edu.ifsp.pep.Modelo.Cliente;
import br.edu.ifsp.pep.Modelo.Conta;
import br.edu.ifsp.pep.Modelo.ContaCorrente;
import br.edu.ifsp.pep.Modelo.ContaEspecial;
import br.edu.ifsp.pep.Modelo.ContaId;
import br.edu.ifsp.pep.Modelo.ContaPoupanca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Principal {
    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("conexaoPU");
    
    public static void main(String[] args) {
        Cliente c1 = adicionarCliente("Joao", "jota@gmail.com");
        Cliente c2 = adicionarCliente("Barbara", "jime@gmail.com");
        Cliente c3 = adicionarCliente("Bruno", "brucer@gmail.com");
        
        adicionarConta(0.0, c1, "1254-7", "37.264-6");
        adicionarConta(2000.0, c2, "0925-3", "50.482-1");
        adicionarConta(0.0, c3, "0925-3", "24.329-6");
        
        adicionarContaCorrente(367.42, c1, 3.94, "8934-1", "12.395-2");
        adicionarContaCorrente(3050.35, c2, 21.84, "0934-5", "19.378-4");
        adicionarContaCorrente(5320.91, c3, 32.67, "8934-1", "01.293-4");
        
        adicionarContaEspecial(0.0, c1, 200.0, "1203-9", "12.798-3");
        adicionarContaEspecial(-1200.24, c2, 5000.0, "1203-9", "61.783-7");
        adicionarContaEspecial(9328.91, c3, 7000.0, "2743-2", "58.912-8");
        
        adicionarContaPoupanca(1042.47, c1, 20, "9382-4", "30.456-7");
        adicionarContaPoupanca(345.35, c2, 15, "5918-7", "19.263-5");
        adicionarContaPoupanca(320.91, c3, 02, "8365-0", "68.509-8");
        
        buscarSaldosVermelhos();
        buscarContaEspecialNegativa();
        buscarPeloAniversario(15);
        somarSaldoContaCorrente();
        maiorSaldoContaEspecial();
    }
    
    public static Cliente adicionarCliente(String nome, String email){
        EntityManager em = enf.createEntityManager();
        Cliente cli = new Cliente(nome, email);
        
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
        em.close();
        
        return cli;
    }
    
    public static void adicionarConta(double Saldo, Cliente cli, String numero, String agencia){
        EntityManager em = enf.createEntityManager();
        Conta conta = new Conta(Saldo, cli);
        ContaId ci = new ContaId(numero, agencia);
        conta.setCodigo(ci);
        
        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void adicionarContaCorrente(double Saldo, Cliente cli, double tarifa, String numero, String agencia){
        EntityManager em = enf.createEntityManager();
        ContaCorrente ce = new ContaCorrente(tarifa, Saldo, cli);
        ContaId ci = new ContaId(numero, agencia);
        ce.setCodigo(ci);
        
        em.getTransaction().begin();
        em.persist(ce);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void adicionarContaEspecial(double Saldo, Cliente cli, double limite, String numero, String agencia){
        EntityManager em = enf.createEntityManager();
        ContaEspecial ce = new ContaEspecial(limite, Saldo, cli);
        ContaId ci = new ContaId(numero, agencia);
        ce.setCodigo(ci);
        
        em.getTransaction().begin();
        em.persist(ce);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void adicionarContaPoupanca(double Saldo, Cliente cli, int aniversario, String numero, String agencia){
        EntityManager em = enf.createEntityManager();
        ContaPoupanca cp = new ContaPoupanca(aniversario, Saldo, cli);
        ContaId ci = new ContaId(numero, agencia);
        cp.setCodigo(ci);
        
        em.getTransaction().begin();
        em.persist(cp);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void buscarSaldosVermelhos(){
        EntityManager em = enf.createEntityManager();
        
        TypedQuery<Conta> query = em.createNamedQuery("Conta.buscarSaldoZeroOuMenor", Conta.class);
        List<Conta> contas = query.getResultList();
        
        System.out.println("Contas com saldo menor ou igual a zero: ");
        if (contas != null) {
            for (Conta conta : contas) {
                System.out.println("Agencia: " + conta.getCodigo().getAgencia() + " Numero: " + conta.getCodigo().getNumero());
                System.out.println("Saldo: " + conta.getSaldo() + "\n");
            }
        }
    }
    
    public static void buscarContaEspecialNegativa(){
        EntityManager em = enf.createEntityManager();
        
        TypedQuery<ContaEspecial> query = em.createNamedQuery("ContaEspecial.buscarContasNoVermelho", ContaEspecial.class);
        List<ContaEspecial> contas = query.getResultList();
        
        System.out.println("Contas Epeciais com saldo menor ou igual a zero:");
        if(contas != null){
            for (ContaEspecial conta : contas) {
                System.out.println("Agencia: " + conta.getCodigo().getAgencia() + " Numero: " + conta.getCodigo().getNumero());
                System.out.println("Saldo: " + conta.getSaldo() + "\n");
            }
        }
    }
    
    public static void buscarPeloAniversario(int aniversario){
        EntityManager em = enf.createEntityManager();
        
        TypedQuery<ContaPoupanca> query = em.createNamedQuery("ContaPoupanca.buscarPeloAniversario", ContaPoupanca.class);
        query.setParameter("aniversario", aniversario);
        List<ContaPoupanca> contas = query.getResultList();
        
        System.out.println("Contas Poupanca que fazem aniversario no dia " + aniversario);
        if(contas != null){
            for (ContaPoupanca conta : contas) {
                System.out.println("Agencia: " + conta.getCodigo().getAgencia() + " Numero: " + conta.getCodigo().getNumero());
                System.out.println("Saldo: " + conta.getSaldo() + "\n");
            }
        }
    }

    public static void somarSaldoContaCorrente(){
        EntityManager em = enf.createEntityManager();
        
        TypedQuery<Double> query = em.createNamedQuery("ContaCorrente.SomaSaldos", Double.class);
        Double result = query.getSingleResult();
        
        System.out.println("Soma dos saldos: R$" + result);
    }

    public static void maiorSaldoContaEspecial(){
        EntityManager em = enf.createEntityManager();
        
        TypedQuery<Double> query = em.createNamedQuery("ContaEspecial.buscarMaiorSaldo", Double.class);
        Double result = query.getSingleResult();
        
        System.out.println("Maior saldo das contas especiais: " + result);
    }
}
