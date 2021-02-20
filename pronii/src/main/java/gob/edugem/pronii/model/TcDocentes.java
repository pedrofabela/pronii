package gob.edugem.pronii.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "TC_DOCENTES")
public class TcDocentes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/******relacion de id sexo pendiente*/
	
	@Id
	@Column(name="N_ID")
	@SequenceGenerator(allocationSize = 1, name = "sqTcDocentes", sequenceName = "TC_DOCENTES_SEQ")
    @GeneratedValue(generator = "sqTcDocentes", strategy = GenerationType.SEQUENCE)
	private Long nId;
	@Column(name = "S_CURP")
	private String sCurp;
	@Column(name = "S_NOMBRE")
	private String sNombre;
	@Column(name = "S_PRIMERAPELLIDO")
	private String sPrimerApellido;
	@Column(name = "S_SEGUNDOAPELLIDO")
	private String sSegundoApellido;
	@Column(name = "N_IDSEXO")
	private Long nIdSexo;
	@Column(name = "D_FECHANACIMIENTO")
	private String sFechaNacimiento;
	@Column(name = "S_CLAVESERPUB")
	private String sClaveSerPub;
	@Column(name = "S_TELEFONO")
	private String sTelefono;
	@Column(name = "N_ESTATUS")
	private Integer nEstatus;
	@Column(name = "S_CORREO")
	private String sCorreo;
	@Column(name = "N_IDPREPROFE")
	private Long nIdPreProfe;
	@Column(name = "S_FECHAINGRESOSUBSISTEMA")
	private String sFechaIngresoSubsistema;
	@Column(name = "N_IDESCUELARADI")
	private String nIdEscuelaRadi;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "N_IDSEXO", referencedColumnName = "N_ID", updatable = false, insertable = false)
	   private TcGenero tcGenero;
	
	@OneToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "N_IDPREPROFE", referencedColumnName = "N_ID", updatable = false, insertable = false)
	   private TcPreProfe tcPreProfe;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDESCUELARADI", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcEscuela tcEscuela;
	
	
	
	public Long getnId() {
		return nId;
	}
	public void setnId(Long nId) {
		this.nId = nId;
	}
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
	public String getsPrimerApellido() {
		return sPrimerApellido;
	}
	public void setsPrimerApellido(String sPrimerApellido) {
		this.sPrimerApellido = sPrimerApellido;
	}
	public String getsSegundoApellido() {
		return sSegundoApellido;
	}
	public void setsSegundoApellido(String sSegundoApellido) {
		this.sSegundoApellido = sSegundoApellido;
	}
	public Long getnIdSexo() {
		return nIdSexo;
	}
	public void setnIdSexo(Long nIdSexo) {
		this.nIdSexo = nIdSexo;
	}
	public String getsFechaNacimiento() {
		return sFechaNacimiento;
	}
	public void setsFechaNacimiento(String sFechaNacimiento) {
		this.sFechaNacimiento = sFechaNacimiento;
	}
	public String getsClaveSerPub() {
		return sClaveSerPub;
	}
	public void setsClaveSerPub(String sClaveSerPub) {
		this.sClaveSerPub = sClaveSerPub;
	}
	public String getsTelefono() {
		return sTelefono;
	}
	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}
	public Integer getnEstatus() {
		return nEstatus;
	}
	public void setnEstatus(Integer nEstatus) {
		this.nEstatus = nEstatus;
	}
	public String getsCorreo() {
		return sCorreo;
	}
	public void setsCorreo(String sCorreo) {
		this.sCorreo = sCorreo;
	}
	public TcGenero getTcGenero() {
		return tcGenero;
	}
	public void setTcGenero(TcGenero tcGenero) {
		this.tcGenero = tcGenero;
	}
	
	public Long getnIdPreProfe() {
		return nIdPreProfe;
	}
	public void setnIdPreProfe(Long nIdPreProfe) {
		this.nIdPreProfe = nIdPreProfe;
	}
	public TcPreProfe getTcPreProfe() {
		return tcPreProfe;
	}
	public void setTcPreProfe(TcPreProfe tcPreProfe) {
		this.tcPreProfe = tcPreProfe;
	}
	
	
	
	public String getsFechaIngresoSubsistema() {
		return sFechaIngresoSubsistema;
	}
	public void setsFechaIngresoSubsistema(String sFechaIngresoSubsistema) {
		this.sFechaIngresoSubsistema = sFechaIngresoSubsistema;
	}
	
	
	
	public String getnIdEscuelaRadi() {
		return nIdEscuelaRadi;
	}
	public void setnIdEscuelaRadi(String nIdEscuelaRadi) {
		this.nIdEscuelaRadi = nIdEscuelaRadi;
	}
	public TcEscuela getTcEscuela() {
		return tcEscuela;
	}
	public void setTcEscuela(TcEscuela tcEscuela) {
		this.tcEscuela = tcEscuela;
	}
	@Override
	public String toString() {
		return "TcDocentes [nId=" + nId + ", sCurp=" + sCurp + ", sNombre=" + sNombre + ", sPrimerApellido="
				+ sPrimerApellido + ", sSegundoApellido=" + sSegundoApellido + ", nIdSexo=" + nIdSexo
				+ ", sFechaNacimiento=" + sFechaNacimiento + ", sClaveSerPub=" + sClaveSerPub + ", sTelefono="
				+ sTelefono + ", nEstatus=" + nEstatus + ", sCorreo=" + sCorreo + ", tcGenero=" + tcGenero + "]";
	}
	
	
	
	
	
	

}
