package main.Algoritmos.metodos;

import main.Algoritmos.Red;

public class NetMask {
    private static NetMask netMask;
    private Red red;

    public static NetMask getNetMask(){
        if (netMask == null){
            netMask = new NetMask();
        }
        return netMask;
    }

    public void netMask_(){

    }
}
