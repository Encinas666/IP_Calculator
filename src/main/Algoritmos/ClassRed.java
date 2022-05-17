package main.Algoritmos;

import main.ValoresIniciales;

public class ClassRed extends Red{
    String red1;
    Integer [] red;
    long []binario;
    String typeRed;


    public ClassRed(String red1){
        this.red1 = red1;
        red = new Integer[4];
        binario = new long[4];
        typeRed ="";
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

    public void getClassRed(String NameRed){
        typeRed = NameRed;
    }
    
    public Integer[] getRed(){
        return red;
    }

    //Metodos auxiliares

    @Override
    public void run() {
        convertAlfaNumerico();
    }

    @Override
    public String getMostrarRed(){
        return "";
    }

    @Override
    public String getRedClass() {
        return typeRed;
    }

    @Override
    public String getMascaraRed() {
        return "";
    }

}
