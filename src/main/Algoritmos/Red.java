package main.Algoritmos;

import java.util.ArrayList;

public abstract class Red {
    public abstract void run();
    public abstract ArrayList<Quadrant> getQuadrants();
    public abstract String getNetMask();
    public abstract String getType();
    public abstract String getBroadcast();
    public abstract String getFirstaIp();
    public abstract String getLastIp();
    public abstract String getIpAvailable();
    public abstract String getSubnetAddress();    
}
