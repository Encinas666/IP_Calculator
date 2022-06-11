package pruebas_unitarias;

import main.Algoritmos.Convert;
import main.Algoritmos.NetworkCalculations;
import main.Algoritmos.Quadrant;
import main.ValoresIniciales;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestClass{
    private NetworkCalculations net;
    private Quadrant[] qu;
    private Convert c;

    public TestClass(){
        ValoresIniciales.mask = 24;
        net = new NetworkCalculations("177.222.96.70");
        net.run();
        qu = new Quadrant[4];
        c = new Convert();
    }
    @Test
    public void testBroadcast(){
        assertEquals("177.222.96.255", net.getBroadcast());
    }

    @Test
    public void testHostRange(){
        assertEquals("177.222.96.1//177.222.96.254", net.getHostRange());
    }

    @Test
    public void testNetworkAddress(){
        assertEquals("177.222.96.0", net.getNetworkAddress());
    }

    @Test
    public void testNetworkMask(){
        assertEquals("255.255.255.0", net.getNetworkMask());
    }

    @Test
    public void testNetworkName(){
        assertEquals("Type: PUBLIC NETWORK--Class B",net.getTypeNetwork());
    }

    public void Sub_Networks(){}

    // Testing de la clase Convert
    @Test
    public void testConvertAlphaNumeric(){
        String p = "";
        qu = c.convertToAlphanumeric("177.222.96.70");
        for(Quadrant q:qu ){
            p = p + q.toString();
        }
        assertEquals("1772229670",p);
    }

}

