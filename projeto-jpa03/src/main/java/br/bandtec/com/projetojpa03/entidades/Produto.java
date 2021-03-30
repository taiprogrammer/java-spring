package br.bandtec.com.projetojpa03.entidades;



import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotBlank
    @NotNull
    @Size(min = 2, max = 40)
    private String nome;
    @Email
    @NotNull
    @Column(length = 120, name = "nome_de_quem_vendeu")
    private String emailFornecedor;
    @CPF
    //exemplos com stella
    private String cpfFornecedor;
    @CNPJ
    private String cnpjFornecedor;
    @TituloEleitoral
    private String tituloEleitoralFornecedor;
    //fim de exemplos stella
    @PositiveOrZero
    @NotNull //faz o campo ser obrigatório
    private Double preco;
    @Future
    @NotNull
    private LocalDate validade;

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    public String getCpfFornecedor() {
        return cpfFornecedor;
    }

    public void setCpfFornecedor(String cpfFornecedor) {
        this.cpfFornecedor = cpfFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getTituloEleitoralFornecedor() {
        return tituloEleitoralFornecedor;
    }

    public void setTituloEleitoralFornecedor(String tituloEleitoralFornecedor) {
        this.tituloEleitoralFornecedor = tituloEleitoralFornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
