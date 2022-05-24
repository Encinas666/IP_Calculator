package main.Algoritmos;

import java.util.ArrayList;

import main.Algoritmos.metodos.MascaraDeRed;
import main.Algoritmos.metodos.NetworkName;
import main.ValoresIniciales;

public class NetworkCalculations{
    private String red1, netType, netMask, broadcast, firstIp, lastIp, ipAvailable, subnetAddress;;
    private Quadrant[] quadrant;

    private Convert c;


    public NetworkCalculations(String red1){
        this.red1 = red1;
        quadrant = new Quadrant[4];
        netMask = "";
        netType ="";
        firstIp = "";
        lastIp = "";
        ipAvailable = "";
        subnetAddress = "";
        c = new Convert();
    }

    public void networkCalculations(){
        netType = NetworkName.geNetworkName(getQuadrants(),red1).networkClass();
        setNetworkQuadrants();
    }

    //metodos auxiliares
    public String getNetCal(){
        String res ="";
        int i = 0;
        for (Quadrant c1 : quadrant) {
            if(i == 3){
                res = res + c1.getQuadrant();
            }else{
                res = res + c1.getQuadrant() + ".";
            }
            i++;
        }
        return res;
    }

    private void convertAlfaNumerico(){
        boolean res = false;
        int tamCad = red1.length();
        int aux = 0;
        int j = 0, i = 0;
        if(tamCad>=7 && tamCad <= 15){
            while(i < tamCad){
                if(red1.charAt(i) == '.'){
                    String a = red1.substring(aux,i);
                    try{
                        Quadrant x = new Quadrant(Long.parseLong(a));
                        if(x.getQuadrant() >= 0 && x.getQuadrant() < 256){
                            quadrant[j] = x;
                            aux = i+1;
                            j++;
                        }else{
                            break;
                        }
                    }catch(NumberFormatException e){
                        break;
                    }
                }else if(i == tamCad-1){
                    String a = red1.substring(aux,i+1);
                    try{
                        Quadrant x = new Quadrant(Long.parseLong(a));
                        if(x.getQuadrant() >= 0 && x.getQuadrant() < 256){
                            quadrant[j] = x;
                        }else{
                            break;
                        }
                    }catch(NumberFormatException e){
                        e.getMessage();
                        break;
                    }
                }
                i++;
            }
        }
    }

    public void setClassRed(String NameRed){
        netType = NameRed;
    }

    public void setNetworkQuadrants(){
        String[] NM =MascaraDeRed.getMascaraDeRed().mascaraDeRed();
        c.convertBin_Dec(NM);
        setQuadrant(c.getC());
        netMask = getNetCal();
    }

    //Metodos auxiliares
    public Quadrant[] getQuadrants() {
        return quadrant;
    }
    public void setQuadrant(Quadrant[] quadrant){
        this.quadrant = quadrant;
    }

    public String getNetMask() {
        return netMask;
    }

    public String getType() {
        return netType;
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

    public String getSubnetAddress() {
        return subnetAddress;
    }

    public String getNet(){
        red1 = red1 + "/" + ValoresIniciales.mask;
        return red1;
    }
    /*--------------------------------------------------------------------------------------------------------*/
    public void run() {
        convertAlfaNumerico();
        networkCalculations();
    }
}
