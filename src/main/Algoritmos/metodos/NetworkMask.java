package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;


public class NetworkMask{
    private static NetworkMask mr;
    private String aux;
    private Quadrant[] q;
    private NetworkMask(){
       q =new Quadrant[4];
    }

    public static NetworkMask getNetworkMask(){
        if (mr == null){
           mr = new NetworkMask();
        }
        return mr;
    }

    public String getNetworkMaskM(){
        Convert c = new Convert();
        networkMaskBinary();
        c.convertBin_Dec(obtainQuadrants());
        q = c.getC();
        return c.getToString(q);
    }

    private void networkMaskBinary(){
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

    private String[] obtainQuadrants(){
        String aux2 = aux;
        String [] oct = new String[4];
        oct[0] = aux.substring(0,8);
        oct[1] = aux.substring(8,16);
        oct[2] = aux.substring(16,24);
        oct[3] = aux.substring(24,32);
        return oct;
    }


}
