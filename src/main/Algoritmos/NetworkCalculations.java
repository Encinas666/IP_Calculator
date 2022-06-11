package main.Algoritmos;

import main.Algoritmos.metodos.*;
import main.ValoresIniciales;

public class NetworkCalculations{
    private String networkType, networkMask, broadcast, networkAddress, network, binary, hostRange;
    private String ipAvailable;
    private Quadrant[] quadrant;
    private String[] quadrantBinary;
    private final Convert c;


    public NetworkCalculations(String network){
        this.network = network;
        quadrant = new Quadrant[4];
        quadrantBinary = new String[4];
        networkType = "";
        networkMask ="";
        broadcast = "";
        hostRange = "";
        ipAvailable = "";
        networkAddress = "";
        binary = "";
        c = new Convert();
    }

    public void networkCalculations(){
        networkType = NetworkName.geNetworkName(getQuadrants()).networkClass();
        networkAddress = NetworkAddress.geNetworkAddress(quadrantBinary).getNetworkAddress();
        networkMask = NetworkMask.getNetworkMask().getNetworkMaskM(1);
        broadcast = Broadcast.getBroadcast().getBroadcastM(quadrantBinary);
        hostRange = HostRange.getHostRange().getHostRangeC(NetworkAddress.geNetworkAddress(quadrantBinary).networkAddressM(),
                Broadcast.getBroadcast().getQuadrantBinary(quadrantBinary));
    }

    //metodos auxiliares
        //metodo temporal para que funcione obtener el broadcast
    private void networkBinary(){
        quadrantBinary[0] = ""+quadrant[0].quadrant();
        quadrantBinary[1] = ""+quadrant[1].quadrant();
        quadrantBinary[2] = ""+quadrant[2].quadrant();
        quadrantBinary[3] = ""+quadrant[3].quadrant();
        c.convertDec_Bin(quadrantBinary);
        quadrantBinary = c.getQuadrantBinary();
        for (int i = 0; i < quadrant.length; i++){
            int sizeQuadrant = quadrantBinary[i].length();
            if(sizeQuadrant != 8){
                String aux = "0" + "0".repeat(Math.max(0, 7 - sizeQuadrant)) + quadrantBinary[i];
                quadrantBinary[i] = aux;
            }
        }
    }


    //Metodos auxiliares
    public Quadrant[] getQuadrants() {
        return quadrant;
    }
    public void setQuadrant(){
        this.quadrant = c.convertToAlphanumeric(network);
    }

    public String getNetworkMask() {
        return networkMask;
    }

    public String getTypeNetwork() {
        return networkType;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public String getHostRange() {
        return hostRange;
    }

    public String getIpAvailable() {
        int bitsR = ValoresIniciales.bits - ValoresIniciales.mask;
        int r =  (int)(Math.pow(2,bitsR)) - 2;
        ipAvailable = r + " hosts";
        return ipAvailable;
    }

    public String getNetworkAddress() {
        return networkAddress;
    }
    @SuppressWarnings("StringConcatenationInLoop")
    public String getNetworkBinary(){
        int i = 0;
        for (String c1 : quadrantBinary) {
            if(i == 3){
                binary = binary + c1;
            }else{
                binary = binary + c1 + ".";
            }
            i++;
        }
        return binary;
    }

    public String getNetwork(){
        network = network + "/" + ValoresIniciales.mask;
        return network;
    }
    /*--------------------------------------------------------------------------------------------------------*/
    public void run() {
        setQuadrant();
        networkBinary();
        networkCalculations();
    }
}
