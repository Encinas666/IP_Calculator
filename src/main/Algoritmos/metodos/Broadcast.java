package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;

public class Broadcast {
    private static Broadcast B;
    private final String[] quadrantBinary;
    private Quadrant[] q;
    private final Convert c;

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

    private void broadcastCalculate(String [] quadrantB){
        int x = 0;
        int y = quadrantB.length-1;
        for (int i = 0; i <=y; i++) {
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
        c.convertBin_Dec(quadrantBinary);
        q=c.getC();
        return c.getToString(q);
    }
    public String[] getQuadrantBinary(String[] qb){
        broadcastCalculate(qb);
        return  quadrantBinary;
    }
}
