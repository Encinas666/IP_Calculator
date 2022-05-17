package main.Algoritmos.metodos;

import main.ValoresIniciales;
import main.Algoritmos.ConvertirBin_Dec;
import main.Algoritmos.ConvertirDec_Bin;
import main.Algoritmos.Red;

public class MascaraDeRed{
    private static MascaraDeRed mr;
    String aux;

    public static MascaraDeRed getMascaraDeRed(){
        if (mr == null){
           mr = new MascaraDeRed();
        }
        return mr;
    }

    public void mascaraDeRed(Red red){
        if(red instanceof ConvertirBin_Dec){
            ConvertirBin_Dec cbd = (ConvertirBin_Dec) red;
            netMaskBin();
            cbd.MaskD(obtenerOct());
        }
        if(red instanceof ConvertirDec_Bin){
            ConvertirDec_Bin cdb = (ConvertirDec_Bin) red;
            netMaskBin();
            cdb.MaskB(obtenerOct());
        }
    }

    private void netMaskBin(){
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
