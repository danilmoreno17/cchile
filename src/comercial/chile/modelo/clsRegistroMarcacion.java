package comercial.chile.modelo;

import java.util.Date;

public class clsRegistroMarcacion {
	
	private int intNumCA;
	private String strEmpleado;
	private Date dtFechaHoraEntrada;
	private Date dtFechaHoraSalida;
	
	
	public clsRegistroMarcacion() {
		this.intNumCA = 0;
		this.strEmpleado = "";
		this.dtFechaHoraEntrada = new Date();
		this.dtFechaHoraSalida = new Date();
	}
	
	public int getIntNumCA() {
		return intNumCA;
	}
	public void setIntNumCA(int intNumCA) {
		this.intNumCA = intNumCA;
	}
	public String getStrEmpleado() {
		return strEmpleado;
	}
	public void setStrEmpleado(String strEmpleado) {
		this.strEmpleado = strEmpleado;
	}
	
	public Date getDtFechaHoraEntrada() {
		return dtFechaHoraEntrada;
	}

	public void setDtFechaHoraEntrada(Date dtFechaHoraEntrada) {
		this.dtFechaHoraEntrada = dtFechaHoraEntrada;
	}

	public Date getDtFechaHoraSalida() {
		return dtFechaHoraSalida;
	}

	public void setDtFechaHoraSalida(Date dtFechaHoraSalida) {
		this.dtFechaHoraSalida = dtFechaHoraSalida;
	}
	
}
