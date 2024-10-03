package org.example;

public class PrimeraEdicion extends Torneo{
    public PrimeraEdicion(int jugadores, String nomEquipo, float porcentajeVic, boolean inscripcion) {
        super(jugadores, nomEquipo, porcentajeVic, inscripcion);
    }
    private boolean eliminado;
    private String notas;

    public PrimeraEdicion(int jugadores, String nomEquipo, float porcentajeVic, boolean inscripcion, boolean eliminado, String notas) {
        super(jugadores, nomEquipo, porcentajeVic, inscripcion);
        this.eliminado = eliminado;
        this.notas = notas;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
