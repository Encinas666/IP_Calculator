package main.listeners;

import javax.swing.*;

import main.ValoresIniciales;
import main.Algoritmos.Opciones;
import main.Algoritmos.Red;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class MyMouseListener implements MouseListener{
    private Red red;
    private final JPanel panel;

    public MyMouseListener(Red red, JPanel panel) {
        this.red = red;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {j
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (ValoresIniciales.opcion == Opciones.BITS){
           
        }
        panel.removeAll();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
