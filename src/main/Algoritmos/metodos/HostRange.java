package main.Algoritmos.metodos;

import main.Algoritmos.Convert;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;

public class HostRange {
    private static HostRange HR;
    private String hostRange;
    private Quadrant[] qh1;
    private final Convert c;

    private HostRange(){
        c = new Convert();
        qh1 = new Quadrant[4];
        hostRange = "";
    }

    public static HostRange getHostRange(){
        if (HR == null){
            HR = new HostRange();
        }
        return HR;
    }

    private void firstHost(String[] network){
        String[] aux = network;
        char[] lastQuadrant = aux[3].toCharArray();
        lastQuadrant[7] = '1';
        aux[3] = String.valueOf(lastQuadrant);
        c.convertBin_Dec(aux);
        qh1 = c.getC();
        hostRange = hostRange + c.getToString(qh1);
    }
    private void lastHost(String[] network) {
        String[] aux = network;
        char[] lastQuadrant = aux[3].toCharArray();
        lastQuadrant[7] = '0';
        aux[3] = String.valueOf(lastQuadrant);
        c.convertBin_Dec(aux);
        qh1 = c.getC();
        hostRange = hostRange + "/" + c.getToString(qh1);
    }
    public String getHostRangeC(String[] network, String[] broadcast){
        firstHost(network);
        lastHost(broadcast);
        return hostRange;
    }
}
