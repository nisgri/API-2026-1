package br.com.serratec.exerciciosaula6.model;

import jakarta.persistence.Entity;

@Entity
public class Gerente extends Empregado{
    private Double adicional;

    public Double getAdicional() {
        return adicional;
    }

    public void setAdicional(Double adicional) {
        this.adicional = adicional;
    }
    
}
