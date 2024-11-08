package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entity.NivelAcesso;
import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named //ManageBean
//@RequestScoped //Escopo do tipo Request
@ViewScoped //Escopo do tipo View
//@SessionScoped //Escopo do tipo session (para cada cliente)
//@ApplicationScoped //Escopo único para a aplicação
public class PessoaController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;
    
    @Inject
    private LoginController lg;
    
    private Pessoa pessoa = new Pessoa();
    private Pessoa pessoaSelecionada;
    private List<Pessoa> pessoas;
    private List<Pessoa> pessoasFinanceiro;

    public PessoaController() {
    }

    public void exibir() {
        System.out.println("Método exibir");

        if (pessoaSelecionada != null) {
            System.out.println(pessoaSelecionada.getNome());
        }

//        for (Pessoa p : pessoas) {
//            System.out.println("Nome: " + p.getNome());
//        }
    }

    public String remover() {
        if (pessoaSelecionada != null) {
            pessoaDAO.excluir(pessoaSelecionada);
            pessoas = null;
            pessoasFinanceiro = null;

            Mensagem.sucesso("Pessoa excluída.");
            
            if(pessoaSelecionada != lg.getPessoaAutenticada()){
                return lg.sair();
            }
        } else {
            Mensagem.atencao("Selecione uma Pessoa.");
        }
        
        return null;
    }

    public void adicionar() {
        Pessoa p = pessoaDAO.autenticarLogin(pessoa.getLogin());
        
        if(p == null){
            pessoa.setLogin(pessoa.getLogin().toLowerCase());
            pessoaDAO.inserir(pessoa); //Insere no BD

            //Para permitir atualizar os dados no BD
            pessoas = null;
            pessoasFinanceiro = null;

            this.pessoa = new Pessoa();
            Mensagem.sucesso("Pessoa cadastrada com Sucesso.");
        } else {
            Mensagem.erro("Login já existente. ");
        }
    }
    
    public void adicionarFinanceiro(){
        this.pessoa.setNivelAcesso(NivelAcesso.Financeiro);
        adicionar();
    }
    
    public String cadastro(){
        Pessoa p = pessoaDAO.autenticarLogin(pessoa.getLogin());
        
        if(p == null){
            pessoa.setLogin(pessoa.getLogin().toLowerCase());
            pessoaDAO.inserir(pessoa);
            lg.setPessoa(pessoa);
            return lg.cadastro();
        } else {
            Mensagem.erro("Login já existente. ");
            return null;
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public List<Pessoa> getPessoas() {
        if (pessoas == null) {
            pessoas = pessoaDAO.buscarTodas();
        }
        return pessoas;
    }
    
    public List<Pessoa> getPessoasFinanceiro() {
        if (pessoasFinanceiro == null) {
            pessoas = pessoaDAO.buscarFinanceiro();
        }
        return pessoasFinanceiro;
    }
    
    public boolean exibirItemMenu() {
        return true;
    }

}
