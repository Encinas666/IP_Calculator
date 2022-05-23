package main.Algoritmos;

import java.util.ArrayList;

public class Convert {
    private ArrayList<Quadrant> c;

    public Convert(){
        c = new ArrayList<>();
    }

    //metodos de convercion
    public void convertBin_Dec(String[] c1){
		setRed(c1);

		final long divisor = 10;
		int y = 0;

		for(int x = 0;x < c.size(); x++){
			Quadrant h = c.get(x);
			int digito = 0;
			int decimal = 0;
			for (long i = h.getQuadrant(), j = 0; i>0; i/=divisor, j++) {
				digito = (int)(i%divisor);
				if (digito != 0 && digito !=1) {
					c.set(y, new Quadrant(-1));
				}
				decimal += digito +Math.pow(2,j);
			}
			c.set(y, new Quadrant(decimal));
			y++;
		}
	}

    private void setRed(String[] c1) {
        try {
			for (int i = 0; i < c1.length; i++){
                c.add(new Quadrant(Long.parseLong(c1[i])));
            }
		} catch (Exception e) {
			e.getStackTrace();
		}
    }

    public void convertDec_Bin(String[] c1) {
        setRed(c1);
		int j = 0;

        for(int i = 0;i < c.size(); i++){
            long x = c.get(i).getQuadrant();
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
			c.set(j, new Quadrant(Long.parseLong(binary.toString())));
			j++;
		}
    }

    public ArrayList<Quadrant> getC(){
        return c;
    }
}
