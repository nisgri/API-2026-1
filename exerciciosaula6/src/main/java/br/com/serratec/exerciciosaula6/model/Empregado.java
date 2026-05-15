package br.com.serratec.exerciciosaula6.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.serratec.exerciciosaula6.enums.Turno;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Preencha o nome do empregado.")
    @Size(max = 50, message = "Limite de caracteres: 50.")
    protected String nome;
    
    @NotBlank(message = "Preencha o CPF do empregado.")
    @Size(max = 20, message = "Limite de caracteres: 20.")
    protected String cpf;
    
    @DecimalMin(value = "1600", message = "Salário mínimo: R$1.600,00.")
    protected Double salario;
    
    @NotNull(message = "Preencha o turno do empregado.")
    @Enumerated(EnumType.STRING)
    protected Turno turno;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
