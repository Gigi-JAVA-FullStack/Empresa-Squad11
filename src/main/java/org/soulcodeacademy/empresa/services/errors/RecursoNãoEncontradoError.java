package org.soulcodeacademy.empresa.services.errors;

public class RecursoNãoEncontradoError extends RuntimeException{
    public RecursoNãoEncontradoError(String message){
        super(message);
    }
}
