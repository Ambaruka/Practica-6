package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRMInformacion extends JFrame {


    private JPanel Informacion;
    private JLabel JLTitulo;
    private JLabel JLEquipo;
    private JLabel JLEquipoNom;
    private JLabel JLCantidad;
    private JLabel JLPorcentaje;
    private JLabel JLJugadores;
    private JLabel JLVictorias;
    private JLabel JLInscripcion;
    private JLabel JLSituacion;
    private JLabel JLNotas;
    private JLabel JLInscripcionPago;
    private JLabel JLEliminado;
    private JLabel JLSusNotas;
    private JButton JBAnterior;
    private JButton JBSiguiente;
    private JButton JBVAnterior;
    private JLabel JLMensaje;

    int posicion=0;
    public FRMInformacion(PrimeraEdicion[] primeraEdicions, FRMFormulario frmFormulario) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Informacion);
        setSize(700,500);

        JLCantidad.setText("<html>Cantidad de<br> jugadores /<html>");
        JLPorcentaje.setText("<html>Porcentaje de<br> victorias /<html>");
        datos(primeraEdicions);


        JBAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
                if (posicion==0){
                    JLMensaje.setText("No hay registros anteriores");
                }else {
                    posicion--;
                    datos(primeraEdicions);
                }
            }
        });
        JBSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
                if (primeraEdicions[posicion+1]==null){
                    JLMensaje.setText("No hay más registros");
                }else {
                    posicion++;
                    datos(primeraEdicions);
                }
            }
        });
        JBVAnterior.addActionListener(e -> {
            this.setVisible(false);
            frmFormulario.setVisible(true);
        });
    }

    private void datos(PrimeraEdicion[] primeraEdicions){
        JLEquipoNom.setText(primeraEdicions[posicion].getNomEquipo());
        JLJugadores.setText(String.valueOf(primeraEdicions[posicion].getJugadores()));
        JLVictorias.setText(String.valueOf(primeraEdicions[posicion].getPorcentajeVic())+ "%");
        JLInscripcionPago.setText(pago(primeraEdicions[posicion].isInscripcion()));
        JLEliminado.setText(estado(primeraEdicions[posicion].isEliminado()));
        JLSusNotas.setText(primeraEdicions[posicion].getNotas());
    }

    private String pago(boolean a){
        if (a==true){return "Pagada";}
        else {return "Inpagado";}
    }

    private String estado(boolean a){
        if (a==true){return "Ganador";}
        else {return "Eliminado";}
    }

    private void mensaje(){JLMensaje.setText("");}
}
