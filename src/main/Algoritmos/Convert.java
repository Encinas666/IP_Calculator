package main.Algoritmos;

import java.util.ArrayList;

public class Convert {
    private Quadrant[] c;

    public Convert(){
        c = new Quadrant[4];
    }

    //metodos de convercion
    public void convertBin_Dec(String[] c1){
		setRed(c1);
		long aux1, digito, decimal;
		int exponente;
		int i = 0;
		for (Quadrant aux:c){
			aux1 = aux.getQuadrant();
			exponente = 0;
			decimal = 0;
			while (aux1 != 0){
				digito = aux1 % 10;
				decimal = decimal + digito * (int)Math.pow(2,exponente);
				exponente++;
				aux1 = aux1/10;
			}
			System.out.println(decimal);
			c[i] = new Quadrant(decimal);
			i++;
		}
	}

    private void setRed(String[] c1) {
        try {
			for (int i = 0; i < c1.length; i++){
                c[i] = new Quadrant(Long.parseLong(c1[i]));
            }
		} catch (Exception e) {
			e.getStackTrace();
		}
    }

    public void convertDec_Bin(String[] c1) {
        setRed(c1);

        for(int i = 0;i < c.length; i++){
            long x = c[i].getQuadrant();
			StringBuilder binary = new StringBuilder();
			if (x <= 0) {
				binary.insert(0, "0");
			}
			while (x > 0) {
				short waste = (short) (x % 2);
				x = x / 2;
				// Insertar el dígito al inicio de la cadena
				binary.insert(0, String.valueOf(waste));
			}
			c[i] = new Quadrant(Long.parseLong(binary.toString()));
		}
    }

    public Quadrant[] getC(){
        return c;
    }
}
