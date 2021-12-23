package com.example.evaluadores;

public class elementoevaluarse {
    private  String id;
private String idevaluado;
private String Nombres;
private String genero;
private String situacion;
private String cargo;
private String fechainicio;
private String imgjpg;

    public elementoevaluarse(String id, String idevaluado, String Nombres, String genero, String situacion, String cargo, String fechainicio, String imgjpg) {
        this.id=id;
        this.idevaluado = idevaluado;
        this.Nombres = Nombres;
        this.genero = genero;
        this.situacion = situacion;
        this.cargo = cargo;
        this.fechainicio = fechainicio;
        this.imgjpg = imgjpg;
    }

    public String getId() {
        return id;
    }

    public String getIdevaluado() {
        return idevaluado;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getGenero() {
        return genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public String getImgjpg() {
        return imgjpg;
    }
}
