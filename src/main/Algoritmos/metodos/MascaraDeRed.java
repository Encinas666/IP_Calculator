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
        for(int i = 0; i < 32; i++){
            if(aux.length() < ValoresIniciales.mask){
                aux = aux + 1;
            }else{
                aux = aux + 0;
            }
        }
    }

    private String[] obtenerOct(){
        String aux2 = aux;
        String [] oct = new String[4];
        for(int i = 0; i < 4; i++){
            int j = 0;
            while(j < 8){
                oct[i] = oct[i] + aux2.charAt(j);
                j++;
            }
            aux2 = aux2.substring(j-1, aux2.length());
        }
        return oct;
    }
}
