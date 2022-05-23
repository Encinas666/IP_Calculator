package main.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import main.Algoritmos.Red;

public class CalculosLabel extends JPanel {
    private JLabel red;
    private JLabel rangoHost;
    private JLabel broadcast;
    private JLabel binario;
    private JLabel lblNMDecimal;

    private Red red1;

    private JPanel panel;
    public CalculosLabel(Red red1,JPanel panel){
        this.panel = panel;
        this.red1 = red1;
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setBorder(borderTitle());
    

        Font font = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createEmptyBorder();

        red = new JLabel();
        red.setBounds(40,  40, 300, 50);
        red.setFont(font);
        red.setForeground(Color.WHITE);
        red.setBorder(border("Red:"));
        red.setText("");
        System.out.println(red1.getType());

        lblNMDecimal = new JLabel();
        lblNMDecimal.setBounds(40, 100, 300, 50);
        lblNMDecimal.setFont(font);
        lblNMDecimal.setForeground(Color.WHITE);
        lblNMDecimal.setBorder(border("Mascara de red:"));
        
        //MascaraDeRed.getMascaraDeRed().mascaraDeRed(red1, panel);
        lblNMDecimal.setText("");

        rangoHost = new JLabel();
        rangoHost.setBounds(40,  160, 300, 50);
        rangoHost.setFont(font);
        rangoHost.setForeground(Color.WHITE);
        rangoHost.setBorder(border("Rango host:"));

        broadcast= new JLabel();
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

    public Border borderTitle(){
        return BorderFactory.createTitledBorder(null,"",2,0, null, Color.white);
    }
}
