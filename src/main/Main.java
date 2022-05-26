package main;

import main.GUI.FramePrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(FramePrincipal::new);
    }
}