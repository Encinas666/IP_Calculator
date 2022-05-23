package main.Algoritmos.metodos;

import java.util.ArrayList;

import javax.swing.JPanel;

import main.ValoresIniciales;
import main.Algoritmos.Quadrant;

public class NetworkName {
    private static NetworkName nr;
    String red1;
    ArrayList<Quadrant> red;

    private NetworkName( ArrayList<Quadrant> red, String red1){
        this.red=red;
        this.red1 = red1;
    }


    public static NetworkName geNetworkName(ArrayList<Quadrant> red, String red1){
        if (nr == null){
           nr = new NetworkName(red, red1);
        }
        return nr;
    }

    public String networkClass(){
        String redclass = "";
        if(red.get(0).getQuadrant()>= 1 && red.get(0).getQuadrant() < 127){
            redclass = getRed1() + "\nTipo: "+ NetworkType() +" Clase A";
        }else if(red.get(0).getQuadrant()>= 127 && red.get(0).getQuadrant() < 192){
            redclass = getRed1() + "\nTipo: "+ NetworkType() +" Clase B";
        }else if(red.get(0).getQuadrant()>= 192 && red.get(0).getQuadrant() < 224){
            redclass = getRed1() + "\nTipo: "+ NetworkType() +" Clase C";
        }else if(red.get(0).getQuadrant()>= 224 && red.get(0).getQuadrant() < 240){
            redclass = getRed1() + "\nTipo: "+ NetworkType() + " Clase D";
        }else if(red.get(0).getQuadrant()>= 240 && red.get(0).getQuadrant() < 256){
            redclass = getRed1() + "\nTipo: "+ NetworkType() +" Clase E";
        }
        return redclass;
    }

    //Metodos auxiliares
    private String getRed1(){
        red1 = red1 + "/" + ValoresIniciales.mask;
        return red1;
    }

    private String NetworkType(){
        String res;
        if(red.get(0).getQuadrant() == 10 && red.get(1).getQuadrant() >= 0 && red.get(1).getQuadrant() <= 255){
            res = "Red Privada";
        }else if(red.get(0).getQuadrant() == 172 && red.get(1).getQuadrant() >= 16 && red.get(1).getQuadrant()<= 31){
            res = "Red Privada";
        }else if(red.get(0).getQuadrant() == 198 && red.get(1).getQuadrant() == 168){
            res = "Red Privada";
        }else{
            res = "Red Publica";
        }
        
        return res;
    }
    
}
