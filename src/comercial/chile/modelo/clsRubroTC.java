package comercial.chile.modelo;

public class clsRubroTC {
	private String strLote;
	private String strFecha;
	private String strBanco;
	private String strValorDobra;
	private String strValorEC;
	private String strRetFuente;
	private String strIva;
	private boolean pagado;
	
	
	
	public clsRubroTC() {
		super();
		this.strLote = "";
		this.strFecha = "";
		this.strBanco = "";
		this.strValorDobra = "";
		this.strValorEC = "";
		this.strRetFuente = "";
		this.strIva = "";
		this.pagado = false;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public String getStrLote() {
		return strLote;
	}
	public void setStrLote(String strLote) {
		this.strLote = strLote;
	}
	public String getStrFecha() {
		return strFecha;
	}
	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}
	public String getStrValorDobra() {
		return strValorDobra;
	}
	public void setStrValorDobra(String strValorDobra) {
		this.strValorDobra = strValorDobra;
	}
	public String getStrValorEC() {
		return strValorEC;
	}
	public void setStrValorEC(String strValorEC) {
		this.strValorEC = strValorEC;
	}
	public String getStrRetFuente() {
		return strRetFuente;
	}
	public void setStrRetFuente(String strRetFuente) {
		this.strRetFuente = strRetFuente;
	}
	public String getStrIva() {
		return strIva;
	}
	public void setStrIva(String strIva) {
		this.strIva = strIva;
	}
	public String getStrBanco() {
		return strBanco;
	}
	public void setStrBanco(String strBanco) {
		this.strBanco = strBanco;
	}
}
