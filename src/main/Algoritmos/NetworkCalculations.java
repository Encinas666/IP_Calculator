package main.Algoritmos;

import java.util.ArrayList;


import main.Algoritmos.metodos.NetworkAddress;
import main.Algoritmos.metodos.NetworkMask;
import main.Algoritmos.metodos.NetworkName;
import main.ValoresIniciales;

public class NetworkCalculations{
    private String networkType, networkMask, broadcast, firstIp, lastIp, ipAvailable, networkAddress, network, binary;
    private Quadrant[] quadrant;
    private String[] quadrantBinary;
    private Convert c;


    public NetworkCalculations(String network){
        this.network = network;
        quadrant = new Quadrant[4];
        quadrantBinary = new String[4];
        networkType = "";
        networkMask ="";
        broadcast = "";
        firstIp = "";
        lastIp = "";
        ipAvailable = "";
        networkAddress = "";
        binary = "";
        c = new Convert();
    }

    public void networkCalculations(){

        networkType = NetworkName.geNetworkName(getQuadrants(),network).networkClass();
        networkAddress = NetworkAddress.geNetworkAddress(quadrantBinary).getNetworkAddress();
        networkMask = NetworkMask.getNetworkMask().getNetworkMaskM();
    }

    //metodos auxiliares
        //metodo temporal para que funcione obtener el broadcast
    private void networkBinary(){

        quadrantBinary[0] = ""+quadrant[0].getQuadrant();
        quadrantBinary[1] = ""+quadrant[1].getQuadrant();
        quadrantBinary[2] = ""+quadrant[2].getQuadrant();
        quadrantBinary[3] = ""+quadrant[3].getQuadrant();
        c.convertDec_Bin(quadrantBinary);
        quadrantBinary = c.getQuadrantBinary();
        for (int i = 0; i < quadrant.length; i++){
            int sizeQuadrant = quadrantBinary[i].length();
            if(sizeQuadrant != 8){
                String aux = "0";
                for (int j = 0; j < 7-sizeQuadrant; j++){
                    aux = aux + "0";
                }
                aux = aux + quadrantBinary[i];
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

    public void setQuadrant(Quadrant[] quadrant){
        this.quadrant = quadrant;
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

    public String getFirstIp() {
        return firstIp;
    }

    public String getLastIp() {
        return lastIp;
    }

    public String getIpAvailable() {
        return ipAvailable;
    }

    public String getNetworkAddress() {
        return networkAddress;
    }
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
