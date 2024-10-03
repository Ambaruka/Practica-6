package org.example;


public class Torneo {
    private int jugadores;
    private String nomEquipo;
    private float porcentajeVic;
    private boolean inscripcion;

    public Torneo(int jugadores, String nomEquipo, float porcentajeVic, boolean inscripcion) {
        this.jugadores = jugadores;
        this.nomEquipo = nomEquipo;
        this.porcentajeVic = porcentajeVic;
        this.inscripcion = inscripcion;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public float getPorcentajeVic() {
        return porcentajeVic;
    }

    public void setPorcentajeVic(float porcentajeVic) {
        this.porcentajeVic = porcentajeVic;
    }

    public boolean isInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(boolean inscripcion) {
        this.inscripcion = inscripcion;
    }
}
