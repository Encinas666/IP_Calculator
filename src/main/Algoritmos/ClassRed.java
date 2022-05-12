package main.Algoritmos;

import main.ValoresIniciales;

public class ClassRed extends Red{
    String red1;
    Integer [] red;
    long []binario;
    String redclass;

    public ClassRed(String red1){
        this.red1 = red1;
        red = new Integer[4];
        binario = new long[4];
    }

    public void claseRed(){
        convertAlfaNumerico();
        if(red[0]>= 1 && red[0] < 127){
            redclass = getRed1() + "\nTipo: "+ tipoDeRed() +" Clase A";
        }else if(red[0]>= 127 && red[0] < 192){
            redclass = getRed1() + "\nTipo: "+ tipoDeRed() +" Clase B";
        }else if(red[0]>= 192 && red[0] < 224){
            redclass = getRed1() + "\nTipo: "+ tipoDeRed() +" Clase C";
        }else if(red[0]>= 224 && red[0] < 240){
            redclass = getRed1() + "\nTipo: "+tipoDeRed() + " Clase D";
        }else if(red[0]>= 240 && red[0] < 256){
            redclass = getRed1() + "\nTipo: "+ tipoDeRed() +" Clase E";
        }
        
    }
    
    //Metodos auxiliares

    public String getRed1(){
        red1 = red1 + "/" + ValoresIniciales.mask;
        return red1;
    }

    public Integer[] getRed(){
        return red;
    }

    private void convertAlfaNumerico(){
        try{
            String[] r = red1.split(".");
            for (int i = 0; i < r.length; i++){
                red[i] = Integer.parseInt(r[i]); 
            }
        }catch(NumberFormatException e){
            e.getMessage();
        }
    }

    private String tipoDeRed(){
        String res;
        if(red[0] == 10 && red[1] >= 0 && red[1] <= 255){
            res = "Red Privada";
        }else if(red[0] == 172 && red[1] >= 16 && red[1] <= 31){
            res = "Red Privada";
        }else if(red[0] == 198 && red[1] == 168){
            res = "Red Privada";
        }else{
            res = "Red Publica";
        }
        
        return res;
    }

    @Override
    public String getClaseRed(){
        return redclass;
    }

    @Override
    public String getMostrarRed(){
        return getRed1();
    }

    @Override
    public void run() {
        claseRed();
    }
}
