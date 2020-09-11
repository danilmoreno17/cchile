package comercial.chile.modelo;

import java.util.ArrayList;

public class clsSubArmados {
	private ArrayList<clsArmados> colArmados;
	
	public clsSubArmados() {
		this.setColArmados(new ArrayList<clsArmados>());
	}

	public ArrayList<clsArmados> getColArmados() {
		return colArmados;
	}

	public void setColArmados(ArrayList<clsArmados> colArmados) {
		this.colArmados = colArmados;
	} 
}
