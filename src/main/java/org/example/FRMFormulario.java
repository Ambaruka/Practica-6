package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private JTextField JTVictorias;
    private ButtonGroup jugadores;
    private ButtonGroup pagos;
    private ButtonGroup estado;

    PrimeraEdicion[] primeraEdicion=new PrimeraEdicion[20];
    int array=0;

    public FRMFormulario() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Formulario);
        setSize(700,900);

        jugadores=new ButtonGroup();
        jugadores.add(JRJugador1);
        jugadores.add(JRJugador2);
        jugadores.add(JRJugador3);
        jugadores.add(JRJugador4);
        jugadores.add(JRJugador5);

        pagos=new ButtonGroup();
        pagos.add(JRPagado);
        pagos.add(JRinpago);

        estado=new ButtonGroup();
        estado.add(JRVencedor);
        estado.add(JREliminado);


        JBRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FRMIngreso frmIngreso=new FRMIngreso();
                frmIngreso.setVisible(true);
                Formulario.setVisible(false);
                mensaje();
            }
        });
        JBRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
                boolean posible=posible();
                if (posible==true){
                    primeraEdicion[array]=new PrimeraEdicion(jugadores(),JTEquipo.getText(), Float.parseFloat(JTVictorias.getText()),inscripcion(),estado(),JTANotas.getText());
                    array++;
                    JLMensaje.setText("Registro hecho con exito");
                } else if (array==20) {
                    JLMensaje.setText("Array lleno");
                }else {JLMensaje.setText("Faltan datos");}
            }
        });
        JBVisualizar.addActionListener(e -> {
            mensaje();
            if(array==0){
                JLMensaje.setText("Necesita hacer el registro");
            }
            else {
                this.setVisible(false);
                FRMInformacion frm = new FRMInformacion(primeraEdicion,this);
                frm.setVisible(true);
            }
        });
        JTVictorias.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                mensaje();
                victorias(e);
            }
        });


        JBLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
                JTEquipo.setText("");
                jugadores.clearSelection();
                pagos.clearSelection();
                estado.clearSelection();
                JTVictorias.setText("");
                JTANotas.setText("");
            }
        });
        JTEquipo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                mensaje();
            }
        });
    }
    private void victorias(KeyEvent e){
        if (!(Character.isDigit(e.getKeyChar()))){
            e.consume();
        }

    }

    private boolean posible(){
        boolean posible=false,rbuttons=RadioButtons();
        if (!(JTEquipo.getText().trim().isEmpty() || JTVictorias.getText().trim().isEmpty())&&rbuttons==true){
            if (array<20) {
                posible = true;
            }
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
        else {cantidad=5;}
        return cantidad;
    }

    private boolean inscripcion(){
        if (JRPagado.isSelected()){return true;}
        else {return false;}
    }

    private boolean estado(){
        if (JRVencedor.isSelected()){return true;}
        else {return false;}
    }

    private void mensaje(){
        JLMensaje.setText("");
    }
}
