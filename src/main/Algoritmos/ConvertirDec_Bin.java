package main.Algoritmos;

public class ConvertirDec_Bin extends Red{
	String[] bin;
	long[] redBin;
	String red;

    private ConvertirDec_Bin(){
		bin = new String[4];
		redBin = new long[4];
	}

    public void convertirDec_Bin(Integer[] octD) {
		int j = 0;
		for(Integer i: octD){
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
			bin[j] = binario.toString();
			j++;
		}
	}

    public void MaskB(String[] obtenerOct) {
		int i = 0;
		for (String cad : obtenerOct) {
			if(i == obtenerOct.length-1){
				red = red + cad;
			}else{
				red = red +"."+cad;
			}
			i++;	
		}
    }

	private void getRedBin(){
		try {
			redBin[0] = Long.parseLong(bin[0]);
			redBin[1] = Long.parseLong(bin[1]);
			redBin[2] = Long.parseLong(bin[2]);
			redBin[3] = Long.parseLong(bin[3]);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
    public void run() {
        // TODO
    }

    @Override
    public String getRedClass() {
       return "";
    }

    @Override
    public String getMostrarRed() {
        return "";
    }

    @Override
    public String getMascaraRed() {
        return "";
	}
}
