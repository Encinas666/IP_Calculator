package main.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CalculosLabel extends JPanel {
    private JLabel red;
    private JLabel rangoHost;
    private JLabel broadcast;
    private JLabel binario;

    private JPanel panel;

    public CalculosLabel(JPanel panel){
        this.panel = panel;
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

        rangoHost = new JLabel();
        rangoHost.setBounds(40,  100, 300, 50);
        rangoHost.setFont(font);
        rangoHost.setForeground(Color.WHITE);
        rangoHost.setBorder(border("Rango host:"));

        broadcast= new JLabel();
        broadcast.setBounds(40,  160, 300, 50);
        broadcast.setFont(font);
        broadcast.setForeground(Color.WHITE);
        broadcast.setBorder(border("Broadcast:"));

        binario = new JLabel();
        binario.setBounds(40,  210, 300, 50);
        binario.setFont(font);
        binario.setForeground(Color.WHITE);
        binario.setBorder(border("Binario:"));
        this.add(red);
        this.add(rangoHost);
        this.add(broadcast);
        this.add(binario);
    }
    
    public Border border(String title){
        return BorderFactory.createTitledBorder(null, title,1,0, null, Color.white);
    }

    public Border borderTitle(){
        
        return BorderFactory.createTitledBorder(null, "xxx",2,0, null, Color.white);
    }
}
