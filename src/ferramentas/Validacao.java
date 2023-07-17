package ferramentas;

public class Validacao {

	public static boolean tipoInt(String valor) {
		
		if(valor.matches("[0-9]*") && !valor.isBlank()) {
			return true;
		}
		
		return false;
	}
	
	public static boolean tipoFloat(String valor) {
		
		try {
			Float.parseFloat(valor);
		}catch(NumberFormatException io) {
			return false;
		}
		
		if(!valor.isBlank())return true;
		return false;
	}
}
