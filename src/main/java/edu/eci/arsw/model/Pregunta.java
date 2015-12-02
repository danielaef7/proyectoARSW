package edu.eci.arsw.model;

public class Pregunta {

    private String tipoPregunta;
    private String contenido;

    public Pregunta() {
    }

    public Pregunta(String title, String contenido) {
        this.tipoPregunta = title;
        this.contenido = contenido;
    }

    public String getTipo() {
            return tipoPregunta;
    }

    public String getcontenido() {
        return contenido;
    }

    public void setTipo(String tipoPregunta) {
            this.tipoPregunta = tipoPregunta;
    }

    public void setContent(String contenido) {
        this.contenido = contenido;
    }

}
