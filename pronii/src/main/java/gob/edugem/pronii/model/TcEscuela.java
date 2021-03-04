package gob.edugem.pronii.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TC_ESCUELA")
public class TcEscuela implements Serializable{

	/**
	 * faltan relaciones 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="N_ID")
	@SequenceGenerator(allocationSize = 1, name = "sqTcEscuela", sequenceName = "TC_ESCUELA_SEQ")
    @GeneratedValue(generator = "sqTcEscuela", strategy = GenerationType.SEQUENCE)
	private Long nId;
	
	@Column(name = "S_NOMBRE")
	private String sNombre;
	
	@Column(name = "S_CCT")
	private String sCct;
	
	@Column(name="N_IDTURNO")
	private Long nIdTurno;
	
	@Column(name = "S_DOMICILIO")
	private String sDomicilio;
	
	@Column(name = "S_COLONIA")
	private String sColonia;
	
	@Column(name = "S_LOCALIDAD")
	private String sLocalidad;
	
	@Column(name =  "N_IDMUNICIPIO")
	private Long nIdMunicipio;
	
	@Column(name = "S_TELEFONO")
	private String sTelefono;
	
	@Column(name = "S_CORREO")
	private String sCorreo;
	
	@Column(name = "N_IDZONAESCOLAR")
	private Long nIdZonaEscolar;
	
	@Column(name = "N_ESTATUS")
	private Integer nEstatus;
	
	@Column(name = "N_IDMODALIDAD")
	private Long nIdModalidad;
	
	@Column(name = "N_IDDIRECTOR")
    private Long nIdDirector;
	
	@Column(name = "N_IDREGIONAL")
    private Long nIdRegional;
	
	@Column(name = "N_HORASDETERMINADAS")
	private Integer nHorasDeterminadas;
	
	@Column(name = "N_HORASINDETERMINADAS")
	private Integer nHorasIndeterminadas;
	
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
	
	
	
		
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDTURNO", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcTurno tcTurno;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDMUNICIPIO", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcMunicipio tcMunicipio;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDZONAESCOLAR", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcZonaEscolar tcZonaEscolar;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDMODALIDAD", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcModalidad tcModalidad;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDDIRECTOR", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcDirectores tcDirectores;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDREGIONAL", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcRegional tcRegional;



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

	public String getsCct() {
		return sCct;
	}

	public void setsCct(String sCct) {
		this.sCct = sCct;
	}

	public Long getnIdTurno() {
		return nIdTurno;
	}

	public void setnIdTurno(Long nIdTurno) {
		this.nIdTurno = nIdTurno;
	}

	public String getsDomicilio() {
		return sDomicilio;
	}

	public void setsDomicilio(String sDomicilio) {
		this.sDomicilio = sDomicilio;
	}

	public String getsColonia() {
		return sColonia;
	}

	public void setsColonia(String sColonia) {
		this.sColonia = sColonia;
	}

	public String getsLocalidad() {
		return sLocalidad;
	}

	public void setsLocalidad(String sLocalidad) {
		this.sLocalidad = sLocalidad;
	}

	public Long getnIdMunicipio() {
		return nIdMunicipio;
	}

	public void setnIdMunicipio(Long nIdMunicipio) {
		this.nIdMunicipio = nIdMunicipio;
	}

	public String getsTelefono() {
		return sTelefono;
	}

	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}

	public String getsCorreo() {
		return sCorreo;
	}

	public void setsCorreo(String sCorreo) {
		this.sCorreo = sCorreo;
	}

	public Long getnIdZonaEscolar() {
		return nIdZonaEscolar;
	}

	public void setnIdZonaEscolar(Long nIdZonaEscolar) {
		this.nIdZonaEscolar = nIdZonaEscolar;
	}

	public Integer getnEstatus() {
		return nEstatus;
	}

	public void setnEstatus(Integer nEstatus) {
		this.nEstatus = nEstatus;
	}

	public Long getnIdModalidad() {
		return nIdModalidad;
	}

	public void setnIdModalidad(Long nIdModalidad) {
		this.nIdModalidad = nIdModalidad;
	}

	public Long getnIdDirector() {
		return nIdDirector;
	}

	public void setnIdDirector(Long nIdDirector) {
		this.nIdDirector = nIdDirector;
	}

	public TcTurno getTcTurno() {
		return tcTurno;
	}

	public void setTcTurno(TcTurno tcTurno) {
		this.tcTurno = tcTurno;
	}

	public TcMunicipio getTcMunicipio() {
		return tcMunicipio;
	}

	public void setTcMunicipio(TcMunicipio tcMunicipio) {
		this.tcMunicipio = tcMunicipio;
	}

	public TcZonaEscolar getTcZonaEscolar() {
		return tcZonaEscolar;
	}

	public void setTcZonaEscolar(TcZonaEscolar tcZonaEscolar) {
		this.tcZonaEscolar = tcZonaEscolar;
	}

	public TcModalidad getTcModalidad() {
		return tcModalidad;
	}

	public void setTcModalidad(TcModalidad tcModalidad) {
		this.tcModalidad = tcModalidad;
	}

	public TcDirectores getTcDirectores() {
		return tcDirectores;
	}

	public void setTcDirectores(TcDirectores tcDirectores) {
		this.tcDirectores = tcDirectores;
	}
	
	

	public Long getnIdRegional() {
		return nIdRegional;
	}

	public void setnIdRegional(Long nIdRegional) {
		this.nIdRegional = nIdRegional;
	}

	public TcRegional getTcRegional() {
		return tcRegional;
	}

	public void setTcRegional(TcRegional tcRegional) {
		this.tcRegional = tcRegional;
	}
	
	

	public Integer getnHorasDeterminadas() {
		return nHorasDeterminadas;
	}

	public void setnHorasDeterminadas(Integer nHorasDeterminadas) {
		this.nHorasDeterminadas = nHorasDeterminadas;
	}

	public Integer getnHorasIndeterminadas() {
		return nHorasIndeterminadas;
	}

	public void setnHorasIndeterminadas(Integer nHorasIndeterminadas) {
		this.nHorasIndeterminadas = nHorasIndeterminadas;
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

	@Override
	public String toString() {
		return "TcEscuela [nId=" + nId + ", sNombre=" + sNombre + ", sCct=" + sCct + ", nIdTurno=" + nIdTurno
				+ ", sDomicilio=" + sDomicilio + ", sColonia=" + sColonia + ", sLocalidad=" + sLocalidad
				+ ", nIdMunicipio=" + nIdMunicipio + ", sTelefono=" + sTelefono + ", sCorreo=" + sCorreo
				+ ", nIdZonaEscolar=" + nIdZonaEscolar + ", nEstatus=" + nEstatus + ", nIdModalidad=" + nIdModalidad
				+ ", nIdDirector=" + nIdDirector + ", nIdRegional=" + nIdRegional + ", nHorasDeterminadas="
				+ nHorasDeterminadas + ", nHorasIndeterminadas=" + nHorasIndeterminadas + ", nGrupoPrimero="
				+ nGrupoPrimero + ", nGrupoSegundo=" + nGrupoSegundo + ", nGrupoTercero=" + nGrupoTercero
				+ ", nAlumnosPrimeroH=" + nAlumnosPrimeroH + ", nAlumnosSegundoH=" + nAlumnosSegundoH
				+ ", nAlumnosTerceroH=" + nAlumnosTerceroH + ", nAlumnosPrimeroM=" + nAlumnosPrimeroM
				+ ", nAlumnosSegundoM=" + nAlumnosSegundoM + ", nAlumnosTerceroM=" + nAlumnosTerceroM + ", tcTurno="
				+ tcTurno + ", tcMunicipio=" + tcMunicipio + ", tcZonaEscolar=" + tcZonaEscolar + ", tcModalidad="
				+ tcModalidad + ", tcDirectores=" + tcDirectores + ", tcRegional=" + tcRegional + "]";
	}

	
	
	
	
	
	
	
}
