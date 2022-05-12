package main.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.ValoresIniciales;

public class FrameContenedor extends JFrame{
   // panel de calculos
    public FrameContenedor(String red){
        super("Calculos");
        JPanel pCalculo = new Panel(red);
        this.add(pCalculo, BorderLayout.CENTER);
        init(pCalculo);
    }

    private void init(JPanel panel){
        this.setSize(ValoresIniciales.MAX_WIDTH, ValoresIniciales.MAX_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.add(new CalculosLabel(panel),  BorderLayout.CENTER);
        this.setVisible(true);
    } 
}
