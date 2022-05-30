package main.GUI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.ValoresIniciales;

public class FrameContenedor extends JFrame{
   // panel de calculators
    //private Red red1;
    public FrameContenedor(String red){
        super("Calculators");
        this.add(subnetworkCalculation(2));
        this.add(networkCalculators(red,1));
        init();
    }

    public FrameContenedor(){
        init();
    }
    private void init(){
        this.setSize(ValoresIniciales.MAX_WIDTH, ValoresIniciales.MAX_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setVisible(true);
    }

    private JPanel networkCalculators(String network, int np){
        JPanel panel = new Panel(network, np);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(10, 10,ValoresIniciales.MAX_WIDTH-20, ValoresIniciales.MAX_HEIGHT-200);
        return panel;
    }

    private JPanel subnetworkCalculation(int np){
        JPanel panel = new Panel(np);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(10, 400, ValoresIniciales.MAX_WIDTH-20, ValoresIniciales.MAX_HEIGHT-450);
        return panel;
    }
}
