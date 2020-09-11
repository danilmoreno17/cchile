package comercial.chile.modelo;

public class clsUtil {
	public static String completarCeros(int cantidad, String cadena) {
		int restante = cantidad - cadena.length();
		String justificar = "";
		for(int i=0; i<restante; i++) {
			justificar += "0";
		}
		return justificar + cadena;
	}
}
