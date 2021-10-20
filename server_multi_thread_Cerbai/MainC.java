package com.example;

public class MainC {
    public static void main( String[] args ){
        Multiclient cliente= new Multiclient();
        cliente.connetti();
        cliente.comunica();
    }
}
