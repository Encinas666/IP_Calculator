package main.GUI;

import java.awt.Color;

import javax.swing.JPanel;

import main.ValoresIniciales;
import main.Algoritmos.ClassRed;
import main.Algoritmos.Red;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Panel extends JPanel {
    private Red red_;

    public Panel(){
        init();
    }
    //Informacion del calculo
    public Panel(String red) {
        this();
        red_ = new ClassRed(red);
        //this.addMouseListener(new MyMouseListener(red_, this, this.getGraphics()));
    }
    //panel de listado de sub redes
    // public Panel(int x1, int y1, int x2, int y2) {
    //     this();
    //     figura = new Cuadrado(x1, y1, x2, y2);
    //     this.addMouseListener(new MyMouseListener(figura, this);
    // }

    private void init(){
        this.setLayout(null);
        this.setBackground(Color.BLACK);
    }
}
