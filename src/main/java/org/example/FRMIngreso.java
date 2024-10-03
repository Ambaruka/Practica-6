package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FRMIngreso extends JFrame{
    private JLabel JLTitulo;
    private JTextField JTUsuario;
    private JPasswordField JPContraseña;
    private JButton JBIngresar;
    private JButton JBLimpiar;
    private JLabel JLUsuario;
    private JLabel JLContraseña;
    private JLabel JLMensaje;
    private JPanel inicio;
    private JButton JBRegistrar;

    Usuario[] usuario=new Usuario[5];
    private int array=0,puntero=0;

    public FRMIngreso() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(inicio);
        setSize(700,500);

        JTUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                enter(e,JTUsuario,JPContraseña);
            }
        });

        JPContraseña.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                mensaje();
            }
        });

        JBIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
            boolean contrasena=contrasena(),usuario=usuario(),posible=validaEspacios();
                if(posible==true){
                    if (contrasena == true && usuario == true) {
                        FRMFormulario frmFormulario = new FRMFormulario();
                        frmFormulario.setVisible(true);
                        inicio.setVisible(false);

                    } else if (contrasena == false && usuario == true) {
                        JLMensaje.setText("Contrseña incorrecta");
                    } else {
                        JLMensaje.setText("Usuario inexistente");
                    }
                }else {JLMensaje.setText("Complete todos los datos");}
            }
        });

        JBRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean posible=validaEspacios();
                if (array<5 && posible==true){
                    usuario[array] = new Usuario(JTUsuario.getText(), JPContraseña.getText());
                    array++;
                    JLMensaje.setText("Registro hecho con exito");
                }else if (array==5){JLMensaje.setText("Ya no se pueden hacer más registros ");}
                else {JLMensaje.setText("Complete todos los datos");}
            }
        });

        JBLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                mensaje();
            }
        });

    }
    private boolean usuario(){
        boolean correcto=false;
        for (int i=0;i<array;i++){
            if (JTUsuario.getText().equals(usuario[i].getNombre())){
                correcto=true;
                puntero=i;
                break;
            }
        }
        return correcto;}

    private boolean contrasena(){
        boolean correcta=false;
        if (usuario[puntero].getContraseña().equals(JPContraseña.getText())){
            correcta=true;
    }
    return correcta;
    }

    private boolean validaEspacios(){
        boolean posible=true;
        if (JTUsuario.getText().trim().isEmpty() || JPContraseña.getText().trim().isEmpty()) {
            posible= false;
        }
        return posible;
    }

    private void limpiar(){
        JTUsuario.setText("");
        JPContraseña.setText("");
    }

    private void mensaje(){
        JLMensaje.setText("");
    }

    private void enter(KeyEvent e,JTextField javier,JComponent oskar){
        char letra = e.getKeyChar();
        if (letra == KeyEvent.VK_ENTER) {
            oskar.requestFocus();//pasar el focus al siguiente input
            mensaje();
        }
    }
}
