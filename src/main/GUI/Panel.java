package main.GUI;

//import java.util.spi.CalendarNameProvider;

import javax.swing.JPanel;

import main.ValoresIniciales;
import main.Algoritmos.*;

public class Panel extends JPanel {
    private Red red_;

    public Panel(){
        init();
    }
    //Informacion del calculo
    public Panel(String red) {
        this();
        red_ = new ClassRed(red);
        //this.addMouseListener(new MyMouseListener(red, this);
    }
    //panel de listado de sub redes
    // public Panel(int x1, int y1, int x2, int y2) {
    //     this();
    //     figura = new Cuadrado(x1, y1, x2, y2);
    //     this.addMouseListener(new MyMouseListener(figura, this);
    // }

    private void init(){
        this.setLayout(null);
        this.setBackground(ValoresIniciales.COLOR_FONDO);
        //ValoresIniciales.opcion = null;
    }
}
