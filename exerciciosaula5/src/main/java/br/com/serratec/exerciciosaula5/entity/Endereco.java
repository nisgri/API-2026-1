package br.com.serratec.exerciciosaula5.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Endereco {
    @NotBlank(message = "Preencha o logradouro corretamente.")
    @Size(max = 50, message = "O limite de caracteres é 50.")
    private String logradouro;

    @NotBlank(message = "Preencha o número corretamente.")
    @Size(max = 5, message = "O limite de caracteres é 5.")
    private String numero;

    @NotBlank(message = "Preencha o bairro corretamente.")
    @Size(max = 50, message = "O limite de caracteres é 50.")
    private String bairro;

    @NotBlank(message = "Preencha a cidade corretamente.")
    @Size(max = 50, message = "O limite de caracteres é 50.")
    private String cidade;
    
    @NotBlank(message = "Preencha a UF corretamente.")
    @Size(max = 2, min = 2, message = "O limite de caracteres para UF é 2.")
    private String estado;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
