package br.com.serratec.exerciciosaula6.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.exerciciosaula6.exception.EnumValidationException;

public enum Turno {
    NOTURNO, VESPERTINO, INTEGRAL, MATUTINO;

    @JsonCreator
    public static Turno verificaEnum(String nome) {
        for(Turno turno : Turno.values()) {
            if(turno.name().equals(nome)) {
                return turno;
            }
        }
        throw new EnumValidationException("Turno inválido.");
    }
}
