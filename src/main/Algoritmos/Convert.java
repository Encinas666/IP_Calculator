package main.Algoritmos;
public class Convert {
    private final Quadrant[] c;
	private final String[] quadrantBinary;

    public Convert(){
		c = new Quadrant[4];
		quadrantBinary = new String[4];
    }

    //metodos de convercion
    public void convertBin_Dec(String[] c1){
		setRed(c1);
		long aux1, digito, decimal;
		int exponente;
		int i = 0;
		for (Quadrant aux:c){
			aux1 = aux.quadrant();
			exponente = 0;
			decimal = 0;
			while (aux1 != 0){
				digito = aux1 % 10;
				decimal = decimal + digito * (int)Math.pow(2,exponente);
				exponente++;
				aux1 = aux1/10;
			}
			c[i] = new Quadrant(decimal);
			i++;
		}
	}
	public String getToString(Quadrant[] quadrant){
		StringBuilder res = new StringBuilder();
		int i = 0;
		for (Quadrant c1 : quadrant) {
			if(i == 3){
				res.append(c1.quadrant());
			}else{
				res.append(c1.quadrant()).append(".");
			}
			i++;
		}
		return res.toString();
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
            long x = c[i].quadrant();
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
			quadrantBinary[i] = binary.toString();
		}
    }

	public Quadrant[] convertToAlphanumeric(String network){
		Quadrant[] quadrant = new Quadrant[4];
		int tamCad = network.length();
		int aux = 0;
		int j = 0, i = 0;
		if(tamCad>=7 && tamCad <= 15){
			while(i < tamCad){
				if(network.charAt(i) == '.'){
					String a = network.substring(aux,i);
					try{
						Quadrant x = new Quadrant(Long.parseLong(a));
						if(x.quadrant() >= 0 && x.quadrant() < 256){
							quadrant[j] = x;
							aux = i+1;
							j++;
						}else{
							break;
						}
					}catch(NumberFormatException e){
						break;
					}
				}else if(i == tamCad-1){
					String a = network.substring(aux,i+1);
					try{
						Quadrant x = new Quadrant(Long.parseLong(a));
						if(x.quadrant() >= 0 && x.quadrant() < 256){
							quadrant[j] = x;
						}else{
							break;
						}
					}catch(NumberFormatException e){
						e.getStackTrace();
						break;
					}
				}
				i++;
			}
		}
		return quadrant;
	}

    public Quadrant[] getC(){
        return c;
    }
	public String[] getQuadrantBinary(){
		return quadrantBinary;
	}

}
