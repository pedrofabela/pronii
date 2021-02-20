package gob.edugem.pronii.dto;

public class DtoDatosCurp {
	
	private String sCurp;
	private String sNombre;
	private String sApellidoPaterno;
	private String sApellidoMaterno;
	private String sFechaNacimiento;
	private Long sSexo;
	private String resultado;
	
	
	public String getsCurp() {
		return sCurp;
	}
	public void setsCurp(String sCurp) {
		this.sCurp = sCurp;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsApellidoPaterno() {
		return sApellidoPaterno;
	}
	public void setsApellidoPaterno(String sApellidoPaterno) {
		this.sApellidoPaterno = sApellidoPaterno;
	}
	public String getsApellidoMaterno() {
		return sApellidoMaterno;
	}
	public void setsApellidoMaterno(String sApellidoMaterno) {
		this.sApellidoMaterno = sApellidoMaterno;
	}
	public String getsFechaNacimiento() {
		return sFechaNacimiento;
	}
	public void setsFechaNacimiento(String sFechaNacimiento) {
		this.sFechaNacimiento = sFechaNacimiento;
	}
	
	public Long getsSexo() {
		return sSexo;
	}
	public void setsSexo(Long sSexo) {
		this.sSexo = sSexo;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return "DtoDatosCurp [sCurp=" + sCurp + ", sNombre=" + sNombre + ", sApellidoPaterno=" + sApellidoPaterno
				+ ", sApellidoMaterno=" + sApellidoMaterno + ", sFechaNacimiento=" + sFechaNacimiento + ", sSexo="
				+ sSexo + ", resultado=" + resultado + "]";
	}
	
	
	

}
