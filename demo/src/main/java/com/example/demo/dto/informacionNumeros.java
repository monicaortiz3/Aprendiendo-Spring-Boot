package com.example.demo.dto;

public class informacionNumeros {
    private Integer indice;
    private Integer primo;

    public informacionNumeros(){

    }

    public informacionNumeros(Integer indice, Integer primo) {
        this.indice = indice;
        this.primo = primo;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public Integer getPrimo() {
        return primo;
    }

    public void setPrimo(Integer primo) {
        this.primo = primo;
    }
}
