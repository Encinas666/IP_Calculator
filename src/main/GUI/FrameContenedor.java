package main.GUI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Algoritmos.NetworkCalculations;
import main.ValoresIniciales;

public class FrameContenedor extends JFrame{
   // panel de calculos
    //private Red red1;
    public FrameContenedor(String red){
        super("Calculos");
        JPanel pCalculate = new Panel(red);
        JPanel subnetworkCalculation = new Panel();
        pCalculate.setBounds(10, 10,ValoresIniciales.MAX_WIDTH-20, ValoresIniciales.MAX_HEIGHT-200);
        subnetworkCalculation.setBounds(10, 400,ValoresIniciales.MAX_WIDTH-20, ValoresIniciales.MAX_HEIGHT-400);
        this.add(pCalculate);
        this.add(subnetworkCalculation);
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
}
