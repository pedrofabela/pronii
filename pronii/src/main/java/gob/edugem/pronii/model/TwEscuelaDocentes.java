package gob.edugem.pronii.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TW_ESCUELADOCENTES")
public class TwEscuelaDocentes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "N_ID")
	@SequenceGenerator(allocationSize = 1, name = "sqTwEscuelaDocente", sequenceName = "TW_ESCUELADOCENTES_SEQ")
    @GeneratedValue(generator = "sqTwEscuelaDocente", strategy = GenerationType.SEQUENCE)
	private Long nId;
	
	@Column(name = "N_IDESCUELA")
	private Long nIdEscuela;
	
	@Column(name = "N_IDDOCENTE")
	private Long nIdDocente;
	
	@Column(name = "N_GRUPOPRIMERO")
	private Integer nGrupoPrimero;
	
	@Column(name = "N_GRUPOSEGUNDO")
	private Integer nGrupoSegundo;
	
	@Column(name = "N_GRUPOTERCERO")
	private Integer nGrupoTercero;
	
	@Column(name = "N_ALUMNOSPRIMEROH")
	private Integer nAlumnosPrimeroH;
	
	@Column(name = "N_ALUMNOSSEGUNDOH")
	private Integer nAlumnosSegundoH;
	
	@Column(name = "N_ALUMNOSTERCEROH")
	private Integer nAlumnosTerceroH;
	
	@Column(name = "N_ALUMNOSPRIMEROM")
	private Integer nAlumnosPrimeroM;
	
	@Column(name = "N_ALUMNOSSEGUNDOM")
	private Integer nAlumnosSegundoM;
	
	@Column(name = "N_ALUMNOSTERCEROM")
	private Integer nAlumnosTerceroM;
	
	@Column(name = "N_HORASPRIMERO")
	private Integer nHorasPrimero;
	
	@Column(name = "N_HORASSEGUNDO")
	private Integer nHorasSegundo;
	
	@Column(name = "N_HORASTERCERO")
	private Integer nHorasTercero;
	
	@Column(name = "N_ESTATUS")
	private Integer nEstatus;
	
	@Column(name = "N_TIENELICENCIA")
	private Long nTieneLicencia;
	
	@Column(name = "N_IDTIPOLICENCIA")
	private Long nIdTipoLicencia;
	
	@Column(name = "D_FECHAINICIOLICENCIA")
	private Date  dFechaInicioLicencia;
	
	@Column(name = "D_FECHAFINLICENCIA")
	private Date dFechaFinLicencia;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDESCUELA", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcEscuela tcEscuela;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDDOCENTE", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcDocentes tcDocentes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDTIPOLICENCIA", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcTipoLicencia TcTipoLicencia;


	public Long getnId() {
		return nId;
	}

	public void setnId(Long nId) {
		this.nId = nId;
	}

	public Long getnIdEscuela() {
		return nIdEscuela;
	}

	public void setnIdEscuela(Long nIdEscuela) {
		this.nIdEscuela = nIdEscuela;
	}

	public Long getnIdDocente() {
		return nIdDocente;
	}

	public void setnIdDocente(Long nIdDocente) {
		this.nIdDocente = nIdDocente;
	}

	public Integer getnGrupoPrimero() {
		return nGrupoPrimero;
	}

	public void setnGrupoPrimero(Integer nGrupoPrimero) {
		this.nGrupoPrimero = nGrupoPrimero;
	}

	public Integer getnGrupoSegundo() {
		return nGrupoSegundo;
	}

	public void setnGrupoSegundo(Integer nGrupoSegundo) {
		this.nGrupoSegundo = nGrupoSegundo;
	}

	public Integer getnGrupoTercero() {
		return nGrupoTercero;
	}

	public void setnGrupoTercero(Integer nGrupoTercero) {
		this.nGrupoTercero = nGrupoTercero;
	}
	
	
	public Integer getnAlumnosPrimeroH() {
		return nAlumnosPrimeroH;
	}

	public void setnAlumnosPrimeroH(Integer nAlumnosPrimeroH) {
		this.nAlumnosPrimeroH = nAlumnosPrimeroH;
	}

	public Integer getnAlumnosSegundoH() {
		return nAlumnosSegundoH;
	}

	public void setnAlumnosSegundoH(Integer nAlumnosSegundoH) {
		this.nAlumnosSegundoH = nAlumnosSegundoH;
	}

	public Integer getnAlumnosTerceroH() {
		return nAlumnosTerceroH;
	}

	public void setnAlumnosTerceroH(Integer nAlumnosTerceroH) {
		this.nAlumnosTerceroH = nAlumnosTerceroH;
	}

	public Integer getnAlumnosPrimeroM() {
		return nAlumnosPrimeroM;
	}

	public void setnAlumnosPrimeroM(Integer nAlumnosPrimeroM) {
		this.nAlumnosPrimeroM = nAlumnosPrimeroM;
	}

	public Integer getnAlumnosSegundoM() {
		return nAlumnosSegundoM;
	}

	public void setnAlumnosSegundoM(Integer nAlumnosSegundoM) {
		this.nAlumnosSegundoM = nAlumnosSegundoM;
	}

	public Integer getnAlumnosTerceroM() {
		return nAlumnosTerceroM;
	}

	public void setnAlumnosTerceroM(Integer nAlumnosTerceroM) {
		this.nAlumnosTerceroM = nAlumnosTerceroM;
	}

	public Integer getnHorasPrimero() {
		return nHorasPrimero;
	}

	public void setnHorasPrimero(Integer nHorasPrimero) {
		this.nHorasPrimero = nHorasPrimero;
	}

	public Integer getnHorasSegundo() {
		return nHorasSegundo;
	}

	public void setnHorasSegundo(Integer nHorasSegundo) {
		this.nHorasSegundo = nHorasSegundo;
	}

	public Integer getnHorasTercero() {
		return nHorasTercero;
	}

	public void setnHorasTercero(Integer nHorasTercero) {
		this.nHorasTercero = nHorasTercero;
	}

	public Integer getnEstatus() {
		return nEstatus;
	}

	public void setnEstatus(Integer nEstatus) {
		this.nEstatus = nEstatus;
	}

	public TcEscuela getTcEscuela() {
		return tcEscuela;
	}

	public void setTcEscuela(TcEscuela tcEscuela) {
		this.tcEscuela = tcEscuela;
	}

	public TcDocentes getTcDocentes() {
		return tcDocentes;
	}

	public void setTcDocentes(TcDocentes tcDocentes) {
		this.tcDocentes = tcDocentes;
	}

	

	public TcTipoLicencia getTcTipoLicencia() {
		return TcTipoLicencia;
	}

	public void setTcTipoLicencia(TcTipoLicencia tcTipoLicencia) {
		TcTipoLicencia = tcTipoLicencia;
	}

	public Long getnTieneLicencia() {
		return nTieneLicencia;
	}

	public void setnTieneLicencia(Long nTieneLicencia) {
		this.nTieneLicencia = nTieneLicencia;
	}

	public Long getnIdTipoLicencia() {
		return nIdTipoLicencia;
	}

	public void setnIdTipoLicencia(Long nIdTipoLicencia) {
		this.nIdTipoLicencia = nIdTipoLicencia;
	}

	public Date getdFechaInicioLicencia() {
		return dFechaInicioLicencia;
	}

	public void setdFechaInicioLicencia(Date dFechaInicioLicencia) {
		this.dFechaInicioLicencia = dFechaInicioLicencia;
	}

	public Date getdFechaFinLicencia() {
		return dFechaFinLicencia;
	}

	public void setdFechaFinLicencia(Date dFechaFinLicencia) {
		this.dFechaFinLicencia = dFechaFinLicencia;
	}
	
	
	
	
	

}
