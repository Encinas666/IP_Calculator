package main.Algoritmos.metodos;

import java.util.ArrayList;

import javax.swing.JPanel;

import main.ValoresIniciales;
import main.Algoritmos.Quadrant;

public class NetworkName {
    private static NetworkName nr;
    private String red1;
    private Quadrant[] red;

    private NetworkName( Quadrant[] red, String red1){
        this.red=red;
        this.red1 = red1;
    }


    public static NetworkName geNetworkName(Quadrant[] red, String red1){
        if (nr == null){
           nr = new NetworkName(red, red1);
        }
        return nr;
    }

    public String networkClass(){
        String redclass = "";
        if(red[0].getQuadrant()>= 1 && red[0].getQuadrant() < 127){
            redclass = "Tipo: "+ NetworkType() +"--Clase A";
        }else if(red[0].getQuadrant()>= 127 && red[0].getQuadrant() < 192){
            redclass = "Tipo: "+ NetworkType() +"--Clase B";
        }else if(red[0].getQuadrant()>= 192 && red[0].getQuadrant() < 224){
            redclass = "Tipo: "+ NetworkType() +"--Clase C";
        }else if(red[0].getQuadrant()>= 224 && red[0].getQuadrant() < 240){
            redclass = "Tipo: "+ NetworkType() + "--Clase D";
        }else if(red[0].getQuadrant()>= 240 && red[0].getQuadrant() < 256){
            redclass = "Tipo: "+ NetworkType() +"--Clase E";
        }
        return redclass;
    }

    //Metodos auxiliares
    private String NetworkType(){
        String res;
        if(red[0].getQuadrant() == 10 && red[1].getQuadrant() >= 0 && red[1].getQuadrant() <= 255){
            res = "Red Privada";
        }else if(red[0].getQuadrant() == 172 &&  red[1].getQuadrant() >= 16 &&  red[1].getQuadrant()<= 31){
            res = "Red Privada";
        }else if(red[0].getQuadrant() == 198 && red[1].getQuadrant() == 168){
            res = "Red Privada";
        }else{
            res = "Red Publica";
        }
        return res;
    }
}
