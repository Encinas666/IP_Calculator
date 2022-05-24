package main.Algoritmos.metodos;

import main.ValoresIniciales;


public class MascaraDeRed{
    private static MascaraDeRed mr;
    String aux;

    public static MascaraDeRed getMascaraDeRed(){
        if (mr == null){
           mr = new MascaraDeRed();
        }
        return mr;
    }

    public String[] mascaraDeRed(){
        netMaskBin();
        return obtenerOct();
    }

    private void netMaskBin(){
        ValoresIniciales.op = 1;
        aux = "";
        for(int i = 0; i < 32; i++){

            if(i < ValoresIniciales.mask){
                aux = aux + 1;
            }else{
                aux = aux + 0;
            }
        }

    }

    private String[] obtenerOct(){
        String aux2 = aux;
        System.out.println(aux2);
        String [] oct = new String[4];
        oct[0] = aux.substring(0,8);
        oct[1] = aux.substring(8,16);
        oct[2] = aux.substring(16,24);
        oct[3] = aux.substring(24,32);
        return oct;
    }
}
