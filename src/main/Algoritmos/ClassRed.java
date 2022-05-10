package main.Algoritmos;

import javax.swing.JOptionPane;

public class ClassRed extends Red{
    String red1;
    Integer [] red;
    String cadIP;
    String[] ip;
    long []binario;
    boolean ban = false;
    boolean ban1 = false;
    int C1, H, S, sal;
    int n, n1;
    int oc1, oc2, oc3, oc4;
    int TS = 0;
    int TH= 0;
    int A,B,C,D;


    public ClassRed(String red1){
        this.red1 = red1;
        ip = new String[4];
        binario = new long[4];
        ban = false;
        ban1 = false;
        sal = 0;
        oc1= 0; 
        oc2 = 0;
        oc3 = 0;
        oc4 = 0;
        TS = 0;
        TH= 0;
    }

    public void convertAlfaNumerico(){
        red = new Integer[4];
        try{
            String[] r = red1.split(".");
            for (int i = 0; i < r.length; i++){
                red[i] = Integer.parseInt(r[i]); 
            }
        }catch(NumberFormatException e){
            message("ERROR");
        }
    }
    
    public String claseRed(){
        String redclass = "";
        if(red[0]>= 1 && red[0] < 127){
            redclass = getRed()+"//"+ " Clase A";
        }else if(red[0]>= 127 && red[0] < 192){
            redclass = getRed()+" //"+ " Clase B";
        }else if(red[0]>= 192 && red[0] < 224){
            redclass = getRed() +" //"+ " Clase C";
        }else if(red[0]>= 224 && red[0] < 240){
            redclass = getRed() +" //"+ " Clase D";
        }else if(red[0]>= 240 && red[0] < 256){
            redclass = getRed() +" //"+ " Clase E";
        }else{
            message("Direccion de red invalida!!");
        }
        return redclass;
    }

    private String getRed(){
        String red_ = "";
        for(int i = 0; i<red.length; i++){
            if(i == red.length - 1){
                red_ = red_ + red[i];
            }
            else{
                red_ = red_ +"." + red[i];
            }
        }
        return red_;
    }
   
    //Metodos auxiliares
    private void message(String mensaje){
         JOptionPane.showMessageDialog(null,mensaje);
    }
    
    public String cadIPV(){
        String cad = "";
        for(int i = 0;i < ip.length; i++){
            cad = cad + "\n " + ip[i];
        }
        return cad;
    }
    
    public void octetoBin(String[] octeto){
        for(int i = 0; i < red.length;i++){

        }
    }
    
    //Inicializar algoritmo
    @Override
    public void run(){
        //claseRed();
    }
}
