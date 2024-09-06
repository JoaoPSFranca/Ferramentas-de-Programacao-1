package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity // pode ser alterada pelo bd | precisa ter um construtor sem parametro
@Table(name = "pessoa", uniqueConstraints = { // cria uma regra para as tabelas
    @UniqueConstraint(name = "unique_cpf_nome", columnNames = {"cpf", "nome"}), // impede que tenha dois nomes e cpf iguais, mas não impede que nome tenha dois nomes iguais com cpf difernetes ou o contrário
    @UniqueConstraint(name = "unique_cpf", columnNames = {"cpf"})
}) // define que é uma tabela e o nome da tabela
public class Pessoa implements Serializable {
    
    @Id // chave primária
    @Column(name = "codigo") // nome do atributo
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int codigo;

    @Column(name = "cpf", length = 14, nullable = true)
    private String cpf;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    //enum
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 7, nullable = true)
    private PessoaStatus status;
    
    @Column(name = "salario")
    private double salario;

    @Column(name = "vale_transporte", nullable = true, scale = 2, precision = 8)
    private BigDecimal valeTransporte;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @Column(name = "administrador")
    private boolean administrador;
    
    @Column(name = "financeiro")
    private Boolean financeiro;
    
    @Column(name = "tipo1",  length = 5)
    private char tipo1;
    
    @Column(name = "tipo2",  length = 3)
    private Character tipo2;
    
    @Lob // coisa grande
    @Column(name = "biografia")
    private String biografia;
    
    //@Lob
    @Column(name = "foto", columnDefinition = "Blob")
    private byte[] foto;
    
    public Pessoa (){
        
    }
    
    public Pessoa(int codigo, String nome, PessoaStatus status) {
        this.codigo = codigo;
        this.nome = nome;
        this.status = status;
    }

    public Pessoa(int codigo, String cpf, String nome, PessoaStatus status, double salario, BigDecimal valeTransporte, Date dataNascimento, LocalDate dataAlteracao, LocalDateTime dataCadastro) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.status = status;
        this.salario = salario;
        this.valeTransporte = valeTransporte;
        this.dataNascimento = dataNascimento;
        this.dataAlteracao = dataAlteracao;
        this.dataCadastro = dataCadastro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PessoaStatus getStatus() {
        return status;
    }

    public void setStatus(PessoaStatus status) {
        this.status = status;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public BigDecimal getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(BigDecimal valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Boolean getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(Boolean financeiro) {
        this.financeiro = financeiro;
    }

    public char getTipo1() {
        return tipo1;
    }

    public void setTipo1(char tipo1) {
        this.tipo1 = tipo1;
    }

    public Character getTipo2() {
        return tipo2;
    }

    public void setTipo2(Character tipo2) {
        this.tipo2 = tipo2;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
