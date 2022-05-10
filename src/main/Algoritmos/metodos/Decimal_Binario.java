package main.Algoritmos.metodos;

import main.Algoritmos.ClassRed;
import main.Algoritmos.Red;

public class Decimal_Binario {
    private static Decimal_Binario dAb;
    private Red red;

    public static Decimal_Binario getDecimal_Binario(){
        if (dAb == null){
            dAb = new Decimal_Binario();
        }
        return dAb;
    }

    public void convertirDecimalABinarioManual(Red red,Integer[] ipDecimal) {
		String[] res= new String[4];
		int j = 0;
		if(red instanceof ClassRed){
			ClassRed classRed = (ClassRed) red;
			for(Integer i: ipDecimal){
				StringBuilder binario = new StringBuilder();
				if (i <= 0) {
					binario.insert(0, "0");
				}
				while (i > 0) {
					short residuo = (short) (i % 2);
					i = i / 2;
					// Insertar el dígito al inicio de la cadena
					binario.insert(0, String.valueOf(residuo));
				}
				res[j] = binario.toString();
				j++;
			}
			classRed.octetoBin(res);
		}
	}

}
