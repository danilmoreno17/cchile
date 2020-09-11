package comercial.chile.modelo;

import java.util.ArrayList;
import java.util.List;

public class clsEmpleado {
	private int intNumCA;
	private String strNombreApellido;
	private List<clsRegistroMarcacion> colRegistroMarcacion;
	
	public clsEmpleado() {
		this.intNumCA = 0;
		this.strNombreApellido = "";
		this.colRegistroMarcacion = new ArrayList();
	}
	
	public int getIntNumCA() {
		return intNumCA;
	}
	public void setIntNumCA(int intNumCA) {
		this.intNumCA = intNumCA;
	}
	public String getStrNombreApellido() {
		return strNombreApellido;
	}
	public void setStrNombreApellido(String strNombreApellido) {
		this.strNombreApellido = strNombreApellido;
	}
	public List<clsRegistroMarcacion> getColRegistroMarcacion() {
		return colRegistroMarcacion;
	}
	public void setColRegistroMarcacion(List<clsRegistroMarcacion> colRegistroMarcacion) {
		this.colRegistroMarcacion = colRegistroMarcacion;
	}
}
