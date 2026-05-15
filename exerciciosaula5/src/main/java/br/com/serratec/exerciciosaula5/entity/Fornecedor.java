package br.com.serratec.exerciciosaula5.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o nome da empresa.")
    @Size(max = 50, message = "O limite de caracteres é 50.")
    private String nome;
    
    @NotBlank(message = "Preencha o CNPJ da empresa.")
    @CNPJ(message = "Informe um CNPJ válido")
    @Size(max = 20, message = "O limite de caracteres é 20.")
    private String cnpj;
    
    @NotBlank(message = "Preencha o e-mail comercial da empresa.")
    @Size(max = 50, message = "O limite de caracteres é 50.")
    private String email;
    
    @Valid
    @Embedded
    private Endereco endereco;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
