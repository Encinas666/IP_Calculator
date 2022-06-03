package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;

public class Sub_Networks {
    private static Sub_Networks SN;
    private Convert c;

    private Quadrant[] q;

    private Sub_Networks(){
        c = new Convert();
        q = new Quadrant[4];
    }

    public static Sub_Networks getSub_Network(){
        if (SN == null){
            SN = new Sub_Networks();
        }
        return SN;
    }

    public void sub_netwok(String[] ip_net){
        for (int i = 0; i < ValoresIniciales.nR; i++){
            String ipFirst, broacast, ipLast;
            c.convertBin_Dec(ip_net);
            q = c.getC();

            for (int j = 0; j < q.length; j++){
                // ipFirst =
            }
        }
    }

    private String Suma(String a, String b) {
        long a1 = Long.parseLong(a, 2);
        long b1 = Long.parseLong(b, 2);
        long c1 = a1 + b1;
        String result= Long.toString(c1, 2);
        return result;
    }
}
