package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;
    
    private Pessoa pessoa = new Pessoa();
    
    private Pessoa pessoaAutenticada;

    public String sair(){
        this.pessoaAutenticada = null;
        Mensagem.sucesso("Desconectado!!!");
        return "/index";
    }
    
    public String autenticar() {        
        this.pessoaAutenticada = pessoaDAO.autenticar(pessoa.getLogin().toLowerCase(), pessoa.getSenha());
        
        if (this.pessoaAutenticada != null) {
            Mensagem.sucesso("Logado com Sucesso!!");
            return "/index.xhtml";
        }
        else{
            Mensagem.erro("Login ou Senha inválidos!!!!");
            return null;
        }
    }
    
    public String cadastro() {
        this.pessoaAutenticada = pessoaDAO.autenticar(pessoa.getLogin().toLowerCase(), pessoa.getSenha());
        
        if (pessoaAutenticada != null) {
            Mensagem.sucesso("Cadastrado e Logado com Sucesso!");
            return "/index.xhtml";
        }
        else{
            Mensagem.erro("Cadastro inválido!");
        }
        return null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public Pessoa getPessoaAutenticada() {
        return pessoaAutenticada;
    }

    public void setPessoaAutenticada(Pessoa pessoaAutenticada) {
        this.pessoaAutenticada = pessoaAutenticada;
    }
}
