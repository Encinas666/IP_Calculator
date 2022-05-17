package main.Algoritmos.metodos;

import main.ValoresIniciales;
import main.Algoritmos.ClassRed;
import main.Algoritmos.Red;

public class NombreDeRed {
    private static NombreDeRed nr;
    String red1;


    public static NombreDeRed geNombreDeRed(){
        if (nr == null){
           nr = new NombreDeRed();
        }
        return nr;
    }

    public void claseRed(Red red1,Integer[] red){
        String redclass = "";
        if(red1 instanceof ClassRed){
            ClassRed clRed = (ClassRed)red1;
            if(red[0]>= 1 && red[0] < 127){
                redclass = getRed1() + "\nTipo: "+ tipoDeRed(red) +" Clase A";
            }else if(red[0]>= 127 && red[0] < 192){
                redclass = getRed1() + "\nTipo: "+ tipoDeRed(red) +" Clase B";
            }else if(red[0]>= 192 && red[0] < 224){
                redclass = getRed1() + "\nTipo: "+ tipoDeRed(red) +" Clase C";
            }else if(red[0]>= 224 && red[0] < 240){
                redclass = getRed1() + "\nTipo: "+ tipoDeRed(red) + " Clase D";
            }else if(red[0]>= 240 && red[0] < 256){
                redclass = getRed1() + "\nTipo: "+ tipoDeRed(red) +" Clase E";
            }
            clRed.getClassRed(redclass);
        }
    }

    
    //Metodos auxiliares

    private String getRed1(){
        red1 = red1 + "/" + ValoresIniciales.mask;
        return red1;
    }

    private String tipoDeRed(Integer[] red){
        String res;
        if(red[0] == 10 && red[1] >= 0 && red[1] <= 255){
            res = "Red Privada";
        }else if(red[0] == 172 && red[1] >= 16 && red[1] <= 31){
            res = "Red Privada";
        }else if(red[0] == 198 && red[1] == 168){
            res = "Red Privada";
        }else{
            res = "Red Publica";
        }
        
        return res;
    }
    
}
