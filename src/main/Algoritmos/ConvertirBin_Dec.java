package main.Algoritmos;

public class ConvertirBin_Dec extends Red {
	private String [] dec;
	String red;

    public ConvertirBin_Dec (){
		dec = new String[4];
	}

	public void convertirBin_Dec(long[] octD) {

		final long divisor = 10;
		int y = 0;

		for(long x: octD){
			int digito = 0;
			int decimal = 0;
			for (long i = x, j = 0; i>0; i/=divisor, j++) {
				digito = (int)(i%divisor);
				if (digito != 0 && digito !=1) {
					octD [y] = -1;
				}
				decimal += digito +Math.pow(2,j);
			}
			dec[y] = "" + decimal;
			y++;
		}
	}

	public void MaskD(String[] oct) {
		int i = 0;
		for (String cad : oct){
			if(i == oct.length-1){
				red = red + cad;
			}else{
				red = red +"."+cad;
			}
			i++;
		}
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

	@Override
	public void run() {
		
	}
}
