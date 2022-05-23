package main.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Algoritmos.NetworkCalculations;
import main.ValoresIniciales;
import main.Algoritmos.Red;

public class FrameContenedor extends JFrame{
    private Red red1;
   // panel de calculos
    public FrameContenedor(String red){
        super("Calculos");
        JPanel pCalculate = new Panel(red);
        red1 = new NetworkCalculations(red);
        this.add(pCalculate, BorderLayout.CENTER);
        init(pCalculate);
    }
    private void init(JPanel panel){
        this.setSize(ValoresIniciales.MAX_WIDTH, ValoresIniciales.MAX_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.add(new CalculosLabel(red1,panel),  BorderLayout.CENTER);
        this.setVisible(true);
        red1.run();
    } 
}
