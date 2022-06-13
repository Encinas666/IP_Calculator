package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;

public class SubNetworks {
    private static SubNetworks SN;
    private Convert c;
    private String[] SNets, RH,B;
    private Quadrant[] q;
    private Quadrant[] q1;

    private SubNetworks(){
        c = new Convert();
        q = c.convertToAlphanumeric(ValoresIniciales.networkAddress);
        q1 = c.convertToAlphanumeric(ValoresIniciales.networkAddress);
        SNets = new String[ValoresIniciales.numberSubnets];
        RH = new String[ValoresIniciales.numberSubnets];
        B = new String[ValoresIniciales.numberSubnets];
    }

    public static SubNetworks getSubNetwork(){
        if (SN == null){
            SN = new SubNetworks();
        }
        return SN;
    }

    public String[] subnets(){
        String []res1= new String[ValoresIniciales.numberSubnets];
        int salto = 256-modifiedQuadrant();

        int pos = 0, i = 0;
        while(i < 4){
            if(i != 3){
                if(q1[i].toString().equals("0")){
                    pos = i;
                    break;
                }
            }else{
                pos = i;
            }
            i++;
        }
        addressSN(salto, pos);
        broadcast(salto);
        hostRange(salto);
        for (int x = 0; x < ValoresIniciales.numberSubnets; x++){
          res1[x] = SNets[x]+ "#"+ RH[x] + "#" +B[x];
        }

        return res1;
    }

    private void addressSN(int salto, int pos){
        String[] sn = ValoresIniciales.networkAddress.split("\\.");
        int n = 0;
        SNets[0] = ValoresIniciales.networkAddress;
        for (int i = 1; i < ValoresIniciales.numberSubnets; i++){
            n = n + salto;
            sn[pos]=""+n;
            SNets[i] = sn[0]+"."+sn[1]+"."+sn[2]+"."+sn[3];
        }
    }

    private void broadcast(int salto){
        int x = 0;
        int n = 0;
        int m = 0;
        for (int i = 0, j=1; i < ValoresIniciales.numberSubnets;i++,j++){
            String[] h = SNets[i].split("\\.");
            n = n +salto;
            m = n - 1;
            h[3] =""+m;
            B[i]= h[0]+"."+h[1]+"."+h[2]+"."+h[3];
        }
    }
    public void hostRange(int salto){
        int x = 0;
        int n = 0;
        int m = 0;
        int n1 = 1;
        for (int i = 0, j=1; i < ValoresIniciales.numberSubnets;i++,j++){
            String[] h = SNets[i].split("\\.");
            String[] h1 = B[i].split("\\.");
            h[3] = ""+n1;
            RH[i]= h[0]+"."+h[1]+"."+h[2]+"."+h[3];
            //calcula la primera ip de la siguiente subred
            n1 = n1 + salto;
            //calcula ultima ip disponible de la subred
            n = n + salto;
            m = n -2;
            h1[3] =""+m;
            RH[i]= RH[i] + "//" + h1[0]+"."+h1[1]+"."+h1[2]+"."+h1[3];
        }
    }

    private int modifiedQuadrant(){
        int res = 0, i = 0;
        Quadrant[] q = c.convertToAlphanumeric(ValoresIniciales.subMask);
        while(i < 4){
            if(i != 3){
                if(q[i+1].toString().equals("0")){
                    res = Integer.parseInt(q[i].toString());
                    break;
                }
            }else{
                res = Integer.parseInt(q[i].toString());
            }
            i++;
        }
        System.out.println(res);
        return res;
    }
}
