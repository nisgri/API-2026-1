package br.com.serratec.aula5.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.aula5.exception.EnumValidationException;

public enum Categoria {
    HATCH, SEDAN, SUV, PICAPE, CONVERSIVEL, ESPORTIVO, COUPE;
    
    @JsonCreator
    public static Categoria verificaEnum(String nome) {
        for(Categoria categoria : Categoria.values()) {
            if(categoria.name().equals(nome)) {
                return categoria;
            }
        }
        throw new EnumValidationException("Categoria não encontrada.");
    }
}
