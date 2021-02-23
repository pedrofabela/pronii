package gob.edugem.pronii.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TC_DIRECTORES")
public class TcDirectores implements Serializable{

	
	
	/**
	 * HOLA HOLA
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="N_ID")
	@SequenceGenerator(allocationSize = 1, name = "sqTcDirectores", sequenceName = "TC_DIRECTORES_SEQ")
    @GeneratedValue(generator = "sqTcDirectores", strategy = GenerationType.SEQUENCE)
	private Long nId;
	
	@Column(name = "S_NOMBRE")
	private String sNombre;
	
	@Column(name = "S_TELEFONO")
	private String sTelefono;
	
	@Column(name = "S_CORREOPERSONAL")
	private String sCorrePersonal;
	
	@Column(name = "N_ESTATUS")
	private Integer nEstatus;
	
	@Column(name = "S_CURP")
	private String sCurp;
	
	@Column(name = "S_APELLIDOPATERNO")
	private String sApellidoPaterno;
	
	@Column(name = "S_APELLIDOMATERNO")
	private String sApellidoMaterno;
	
	public Long getnId() {
		return nId;
	}
	public void setnId(Long nId) {
		this.nId = nId;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsTelefono() {
		return sTelefono;
	}
	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}
	public String getsCorrePersonal() {
		return sCorrePersonal;
	}
	public void setsCorrePersonal(String sCorrePersonal) {
		this.sCorrePersonal = sCorrePersonal;
	}
	public Integer getnEstatus() {
		return nEstatus;
	}
	public void setnEstatus(Integer nEstatus) {
		this.nEstatus = nEstatus;
	}
	public String getsCurp() {
		return sCurp;
	}
	public void setsCurp(String sCurp) {
		this.sCurp = sCurp;
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
	@Override
	public String toString() {
		return "TcDirectores [nId=" + nId + ", sNombre=" + sNombre + ", sTelefono=" + sTelefono + ", sCorrePersonal="
				+ sCorrePersonal + ", nEstatus=" + nEstatus + ", sCurp=" + sCurp + "]";
	}
	
	

}
