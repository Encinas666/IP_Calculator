package main.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.ValoresIniciales;

public class FrameContenedor extends JFrame{
   // panel de calculos
    public FrameContenedor(){
        super("Calculos");
        this.add(new Panel(), BorderLayout.CENTER);
        init(new Panel());
    }

    //
    // public FrameContenedor(int x1, int y1, int x2, int y2){
    //     super("Cuadrado");
    //     JPanel pListaSubRedes = new Panel();
    //     this.add(pListaSubRedes, BorderLayout.CENTER);
    //     init(pListaSubRedes);
    // }

    private void init(JPanel panel){
        this.setSize(ValoresIniciales.MAX_WIDTH, ValoresIniciales.MAX_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(ValoresIniciales.COLOR_FONDO);
        this.setResizable(false);
        //this.add(new BotonesOpciones(panel), BorderLayout.LINE_START);
        this.setVisible(true);
    } 
}
