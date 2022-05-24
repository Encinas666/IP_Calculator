package main.GUI;

import main.Algoritmos.NetworkCalculations;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel extends JPanel {
    //private Red red1;
    private NetworkCalculations cr;

    JLabel broadcast;
    JLabel binario;
    JLabel red;
    JLabel lblNMDecimal;
    JLabel rangoHost;
    public Panel() {
        init();
    }

    //Informacion del calculo
    public Panel(String red) {
        this();
        cr = new NetworkCalculations(red);
        setLblText();
    }

    private void init() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        Font font = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createEmptyBorder();

        red = new JLabel();
        red.setBounds(40,  40, 300, 50);
        red.setFont(font);
        red.setForeground(Color.WHITE);
        red.setBorder(border("Red:"));

        lblNMDecimal = new JLabel();
        lblNMDecimal.setBounds(40, 100, 300, 50);
        lblNMDecimal.setFont(font);
        lblNMDecimal.setForeground(Color.WHITE);
        lblNMDecimal.setBorder(border("Mascara de red:"));

        lblNMDecimal.setText("");

        rangoHost = new JLabel();
        rangoHost.setBounds(40,  160, 300, 50);
        rangoHost.setFont(font);
        rangoHost.setForeground(Color.WHITE);
        rangoHost.setBorder(border("Rango host:"));

        broadcast = new JLabel();
        broadcast.setBounds(40,  220, 300, 50);
        broadcast.setFont(font);
        broadcast.setForeground(Color.WHITE);
        broadcast.setBorder(border("Broadcast:"));

        binario = new JLabel();
        binario.setBounds(40,  280, 300, 50);
        binario.setFont(font);
        binario.setForeground(Color.WHITE);
        binario.setBorder(border("Binario:"));

        this.add(red);
        this.add(rangoHost);
        this.add(broadcast);
        this.add(binario);
        this.add(lblNMDecimal);
    }

    public Border border(String title){
        return BorderFactory.createTitledBorder(null, title,1,0, null, Color.white);
    }

    public Border borderTitle(String title){
        return BorderFactory.createTitledBorder(null, title,2,0, null, Color.white);
    }

    public void setLblText(){
        cr.run();
        System.out.println(cr.getType());
        this.setBorder(borderTitle(cr.getType()));
        red.setText(cr.getNet());
        lblNMDecimal.setText(cr.getNetMask());


    }

}
