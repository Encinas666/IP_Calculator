package main.GUI;

import main.Algoritmos.NetworkCalculations;
import main.Algoritmos.Red;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private Red red1;

    public Panel() {
        init();
    }

    //Informacion del calculo
    public Panel(String red) {
        this();
        red1 = new NetworkCalculations(red);
    }

    private void init() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
    }


}
