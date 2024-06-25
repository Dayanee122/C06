package br.inatel.c06.exceptions;

public class SemEstoqueException extends RuntimeException{
    public SemEstoqueException(String message){
        super(message);
    }
}
