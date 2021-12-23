package com.example.evaluadores;

public class elementovista {
    private String imgJPG;
    private String imgjpg;
    private String idevaluador;
    private String nombres;
    private String area;

    public elementovista(String imgJPG, String imgjpg, String idevaluador, String nombres, String area) {
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
        this.idevaluador = idevaluador;
        this.nombres = nombres;
        this.area = area;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public String getImgjpg() {
        return imgjpg;
    }

    public String getIdevaluador() {
        return idevaluador;
    }

    public String getNombres() {
        return nombres;
    }

    public String getArea() {
        return area;
    }
}
