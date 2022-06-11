package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;

public class NetworkAddress {
    private static NetworkAddress NA;
    private final String[] quadrantBinary;
    private Quadrant[] q;
    private final Convert c;

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

    public String[] networkAddressM(){
        String[] binaryNA = new String[4];
        int i = 0 , y = 0;
        for (String aux:quadrantBinary) {
            int x = 0;
            StringBuilder networkAddress = new StringBuilder();
            for (int j = 0; j < aux.length(); j++){
                if(y < ValoresIniciales.mask){
                    networkAddress.append(aux.charAt(x));
                    x++;
                }else{
                    networkAddress.append("0");
                }
                y++;
            }
            binaryNA[i] = networkAddress.toString();
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
