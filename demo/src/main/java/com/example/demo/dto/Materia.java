package com.example.demo.dto;

public class Materia {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double minimoParaPasar;

    public Materia() {}

    public Materia(Long id, String nombre, String descripcion, Double minimoParaPasar) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.minimoParaPasar = minimoParaPasar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMinimoParaPasar() {
        return minimoParaPasar;
    }

    public void setMinimoParaPasar(Double minimoParaPasar) {
        this.minimoParaPasar = minimoParaPasar;
    }
}
