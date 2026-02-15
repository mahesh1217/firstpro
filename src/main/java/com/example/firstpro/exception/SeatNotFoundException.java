package com.example.firstpro.exception;

public class SeatNotFoundException extends  RuntimeException{

    public SeatNotFoundException(String mesaage){
        super(mesaage);
    }
}
