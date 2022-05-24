package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;

public class NetworkAddress {
    private static NetworkAddress NA;
    private String[] quadrantBinary;
    private Quadrant[] q;
    private Convert c;

    private NetworkAddress( String[] quadrantBinary){
        this.quadrantBinary = quadrantBinary;
        c = new Convert();
        q = new Quadrant[4];
    }

    public static NetworkAddress geNetworkAddress(String[] quadrantBinary){
        if (NA == null){
            NA = new NetworkAddress(quadrantBinary);
        }
        return NA;
    }

    public void run(){

    }

    public String[] networkAddressM(){
        String[] binaryNA = new String[4];
        int i = 0 , y = 0;
        for (String aux:quadrantBinary) {
            int x = 0;
            String networkAddress = "";
            for (int j = 0; j < aux.length(); j++){
                if(y < ValoresIniciales.mask){
                    networkAddress = networkAddress + aux.charAt(x);
                    x++;
                }else{
                    networkAddress = networkAddress + "0";
                }
                y++;
            }
            System.out.println(networkAddress);
            binaryNA[i] = networkAddress;
            i++;
        }
        return binaryNA;
    }

    public String getNetworkAddress(){
        c.convertBin_Dec(networkAddressM());
        q = c.getC();
        return c.getToString(q);
    }
}
