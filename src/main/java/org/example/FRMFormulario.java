package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRMFormulario extends JFrame{
    private JPanel Formulario;
    private JLabel JLTitulo;
    private JRadioButton JRJugador1;
    private JRadioButton JRJugador2;
    private JRadioButton JRJugador3;
    private JRadioButton JRJugador4;
    private JRadioButton JRJugador5;
    private JTextField JTEquipo;
    private JSpinner JSVictorias ;
    private JRadioButton JRPagado;
    private JRadioButton JRinpago;
    private JRadioButton JRVencedor;
    private JRadioButton JREliminado;
    private JTextArea JTANotas;
    private JLabel JLEquipo;
    private JLabel JLJugadores;
    private JLabel JLVictorias;
    private JLabel JLInscripcion;
    private JLabel JLEliminacion;
    private JLabel JLNotas;
    private JButton JBRegistrar;
    private JButton JBLimpiar;
    private JButton JBVisualizar;
    private JButton JBRegresar;
    private JLabel JLMensaje;


    public FRMFormulario() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Formulario);
        setSize(700,900);


        JBRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FRMIngreso frmIngreso=new FRMIngreso();
                frmIngreso.setVisible(true);
                Formulario.setVisible(false);
            }
        });
        JSVictorias.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                victorias();
            }
        });
        JBRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean posible=posible();
                if (posible==true){
                    PrimeraEdicion primeraEdicion=new PrimeraEdicion(jugadores(),JTEquipo.getText(),Float.parseFloat((String) JSVictorias.getValue()),inscripcion(),estado(),JTANotas.getText());
                }
            }
        });
    }
    private void victorias(){
        int valor =Integer.parseInt(JSVictorias.getValue().toString());
        if (0 > valor) {
            JSVictorias.setValue(0);
        } else if (valor > 100) {
            JSVictorias.setValue(100);
        }
    }

    private boolean posible(){
        boolean posible=false,rbuttons=RadioButtons();
        if (!(JTEquipo.getText().trim().isEmpty())&&rbuttons==true){
            posible=true;
        }return posible;
    }

    private boolean RadioButtons(){
        return (JRPagado.isSelected() || JRinpago.isSelected())&&(JREliminado.isSelected() || JRVencedor.isSelected())&&JRJugador1.isSelected() || JRJugador2.isSelected() || JRJugador3.isSelected() || JRJugador4.isSelected() || JRJugador5.isSelected();
    }

    private int jugadores(){
        int cantidad;
        if (JRJugador1.isSelected()){cantidad=1;}
        else if (JRJugador2.isSelected()) {cantidad=2;}
        else if (JRJugador3.isSelected()) {cantidad=3;}
        else if (JRJugador4.isSelected()) {cantidad=4;}
        else {cantidad=5;}return cantidad;
    }

    private boolean inscripcion(){
        if (JRPagado.isSelected()){return true;}
        else {return false;}
    }

    private boolean estado(){
        if (JRVencedor.isSelected()){return true;}
        else {return false;}
    }
}
