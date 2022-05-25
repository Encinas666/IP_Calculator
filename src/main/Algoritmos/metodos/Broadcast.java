package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;

import java.lang.invoke.VolatileCallSite;

public class Broadcast {
    private static Broadcast B;
    private String[] quadrantBinary;
    private Quadrant[] q;
    private Convert c;

    private Broadcast(){
        c = new Convert();
        q = new Quadrant[4];
        quadrantBinary = new String[4];
    }

    public static Broadcast getBroadcast(){
        if (B == null){
            B = new Broadcast();
        }
        return B;
    }

    public void broadcastCalculate(String [] quadrantB){
        int x = 0;
        int y = quadrantB.length-1;
        for (int i = 0; i <=y; i++) {
            String aux1 = "";
            char[] aux = quadrantB[i].toCharArray();
            int z = aux.length-1;
            for (int j = 0; j <= z; j++){
                if (x >= ValoresIniciales.mask) {
                    aux[j] = '1';
                }
                x++;
            }
            quadrantBinary[i] = String.valueOf(aux);
        }

    }
    public String getBroadcastM(String[] qb){
        broadcastCalculate(qb);
        for (int j = 0; j < quadrantBinary.length; j++){
            System.out.println(quadrantBinary[j]);
        }

        c.convertBin_Dec(quadrantBinary);
        q=c.getC();
        return c.getToString(q);
    }
}
