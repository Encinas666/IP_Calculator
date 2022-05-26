package main.Algoritmos.metodos;

import main.Algoritmos.Quadrant;

public class NetworkName {
    private static NetworkName nr;
    private final Quadrant[] red;

    private NetworkName( Quadrant[] red){
        this.red=red;
    }


    public static NetworkName geNetworkName(Quadrant[] red){
        if (nr == null){
           nr = new NetworkName(red);
        }
        return nr;
    }

    public String networkClass(){
        String redclass = "";
        if(red[0].quadrant() >= 1 && red[0].quadrant() < 127){
            redclass = "Type: "+ NetworkType() +"--ClassA";
        }else if(red[0].quadrant()>= 127 && red[0].quadrant() < 192){
            redclass = "Type: "+ NetworkType() +"--Class B";
        }else if(red[0].quadrant()>= 192 && red[0].quadrant() < 224){
            redclass = "Type: "+ NetworkType() +"--Class C";
        }else if(red[0].quadrant()>= 224 && red[0].quadrant() < 240){
            redclass = "Type: "+ NetworkType() + "--Class D";
        }else if(red[0].quadrant()>= 240 && red[0].quadrant() < 256){
            redclass = "Type: "+ NetworkType() +"--Class E";
        }
        return redclass;
    }

    //Metodos auxiliares
    private String NetworkType(){
        String res;
        if(red[0].quadrant() == 10 && red[1].quadrant() >= 0 && red[1].quadrant() <= 255){
            res = "PRIVATE NETWORK";
        }else if(red[0].quadrant() == 172 &&  red[1].quadrant() >= 16 &&  red[1].quadrant()<= 31){
            res = "PRIVATE NETWORK";
        }else if(red[0].quadrant() == 198 && red[1].quadrant() == 168){
            res = "PRIVATE NETWORK";
        }else{
            res = "PUBLIC NETWORK";
        }
        return res;
    }
}
