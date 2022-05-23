package main.Algoritmos;

import java.util.ArrayList;

import main.Algoritmos.metodos.MascaraDeRed;
import main.Algoritmos.metodos.NetworkName;

public class NetworkCalculations extends Red{
    private String red1;
    private ArrayList<Quadrant> quadrant;
    private String netType, netMask, broadcast, firstIp, lastIp, ipAvailable, subnetAddress;

    Convert c;


    public NetworkCalculations(String red1){
        this.red1 = red1;
        quadrant = new ArrayList<>();
        netMask = "";
        netType ="";
        firstIp = "";
        lastIp = "";
        ipAvailable = "";
        subnetAddress = "";
        c = new Convert();
    }

    public void networkCalculations(){
        convertAlfaNumerico();
        netType = NetworkName.geNetworkName(quadrant,red1).networkClass();
        setNetworkQuadrants();
    }

    //metodos auxiliares
    public String getNet(ArrayList<Quadrant> c){
        String res ="";
        int i = 0;
        for (Quadrant c1 : c) {
            if(i == 3){
                res = res + c1.getQuadrant();
            }else{
                res = res +"."+ c1.getQuadrant();
            }
        }
        return res;
    }

    private void convertAlfaNumerico(){
        try{
            String[] r = red1.split(".");
            for (int i = 0; i < r.length; i++){
                quadrant.add(new Quadrant(Long.parseLong(r[i])));
            }
        }catch(NumberFormatException e){
            e.getMessage();
        }
    }

    public void setClassRed(String NameRed){
        netType = NameRed;
    }

    public void setNetworkQuadrants(){
        String[] NM =MascaraDeRed.getMascaraDeRed().mascaraDeRed();
        c.convertBin_Dec(NM);
        quadrant = c.getC();
        netMask = getNet(quadrant);
    }

    public void recalculate(){
        this.quadrant.clear();
        networkCalculations();
    }

    //Metodos auxiliares

    @Override
    public void run() {
        networkCalculations();
    }

    @Override
    public ArrayList<Quadrant> getQuadrants() {
        return quadrant;
    }

    @Override
    public String getNetMask() {
        return netMask;
    }

    @Override
    public String getType() {
        return netType;
    }

    @Override
    public String getBroadcast() {
        return broadcast;
    }

    @Override
    public String getFirstaIp() {
        return firstIp;
    }

    @Override
    public String getLastIp() {
        return lastIp;
    }

    @Override
    public String getIpAvailable() {
        return ipAvailable;
    }

    @Override
    public String getSubnetAddress() {
        return subnetAddress;
    }
}
