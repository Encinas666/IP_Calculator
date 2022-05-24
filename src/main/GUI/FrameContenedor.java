package main.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Algoritmos.NetworkCalculations;
//import main.Algoritmos.Red;
import main.ValoresIniciales;

public class FrameContenedor extends JFrame{
   // panel de calculos
    //private Red red1;
    public FrameContenedor(String red){
        super("Calculos");
        JPanel pCalculate = new Panel(red);
        this.add(pCalculate, BorderLayout.CENTER);
        init(pCalculate);

    }
    private void init(JPanel panel){
        this.setSize(ValoresIniciales.MAX_WIDTH, ValoresIniciales.MAX_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setVisible(true);
    } 
}
