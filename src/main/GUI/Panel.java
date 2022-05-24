package main.GUI;

import main.Algoritmos.NetworkCalculations;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel extends JPanel {
    //private Red red1;
    private NetworkCalculations cr;

    JLabel broadcast, networkAddress, networkType, networkMask,binary, network, hostRange;

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

        network= new JLabel();
        network.setBounds(40,  40, 300, 50);
        network.setFont(font);
        network.setForeground(Color.WHITE);
        network.setBorder(border("Network"));

        networkAddress = new JLabel();
        networkAddress.setBounds(40,  100, 300, 50);
        networkAddress.setFont(font);
        networkAddress.setForeground(Color.WHITE);
        networkAddress.setBorder(border("Red:"));

        networkMask = new JLabel();
        networkMask.setBounds(40, 160, 300, 50);
        networkMask.setFont(font);
        networkMask.setForeground(Color.WHITE);
        networkMask.setBorder(border("Mascara de red:"));

        broadcast = new JLabel();
        broadcast.setBounds(40,  220, 300, 50);
        broadcast.setFont(font);
        broadcast.setForeground(Color.WHITE);
        broadcast.setBorder(border("Broadcast:"));

        hostRange = new JLabel();
        hostRange.setBounds(40,  280, 300, 50);
        hostRange.setFont(font);
        hostRange.setForeground(Color.WHITE);
        hostRange.setBorder(border("Rango host:"));

        binary = new JLabel();
        binary.setBounds(40,  340, 300, 50);
        binary.setFont(font);
        binary.setForeground(Color.WHITE);
        binary.setBorder(border("Binario:"));

        this.add(network);
        this.add(networkAddress);
        this.add(networkMask);
        this.add(broadcast);
        this.add(hostRange);
        this.add(binary);
    }

    public Border border(String title){
        return BorderFactory.createTitledBorder(null, title,1,0, null, Color.white);
    }

    public Border borderTitle(String title){
        return BorderFactory.createTitledBorder(null, title,2,0, null, Color.white);
    }

    public void setLblText(){
        cr.run();
        this.setBorder(borderTitle(cr.getTypeNetwork()));
        network.setText(cr.getNetwork());
        networkAddress.setText(cr.getNetworkAddress());
        networkMask.setText(cr.getNetworkMask());
        binary.setText(cr.getNetworkBinary());
    }

}
