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
@Table(name = "TW_CERTMETODOLOGIA")
public class TwMetodologia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="N_ID")
	@SequenceGenerator(allocationSize = 1, name = "secuencia", sequenceName = "TW_CERTMETODOLOGIA_SEQ")
    @GeneratedValue(generator = "secuencia", strategy = GenerationType.SEQUENCE)
	private Long nId;
	
	@Column(name = "N_IDDOCENTE")
	private Long nIdDocente;
	
	@Column(name="N_IDTIPOCERTIFICACION")
	private Long nIdTipoCertificacion;
	
	@Column(name = "N_IDMODULO1")
	private Long nIdModulo1;
	
	@Column(name = "N_IDMODULO2")
	private Long nIdModulo2;
	
	@Column(name = "N_IDMODULO3")
	private Long nIdModulo3;
	
	@Column(name = "D_FECHAEMISION")
	private Date dFechaEmision;
	
	@Column(name = "D_FECHAVENCIMIENTO")
	private Date dFechaVencimineto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDDOCENTE", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcDocentes tcDocentes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDTIPOCERTIFICACION", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcTipoCertificacion tcTipoCertificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDMODULO1", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcModulos tcModulo1;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDMODULO2", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcModulos tcModulo2;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDMODULO3", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcModulos tcModulo3;

	public Long getnId() {
		return nId;
	}

	public void setnId(Long nId) {
		this.nId = nId;
	}

	public Long getnIdDocente() {
		return nIdDocente;
	}

	public void setnIdDocente(Long nIdDocente) {
		this.nIdDocente = nIdDocente;
	}

	public Long getnIdTipoCertificacion() {
		return nIdTipoCertificacion;
	}

	public void setnIdTipoCertificacion(Long nIdTipoCertificacion) {
		this.nIdTipoCertificacion = nIdTipoCertificacion;
	}

	public Long getnIdModulo1() {
		return nIdModulo1;
	}

	public void setnIdModulo1(Long nIdModulo1) {
		this.nIdModulo1 = nIdModulo1;
	}

	public Long getnIdModulo2() {
		return nIdModulo2;
	}

	public void setnIdModulo2(Long nIdModulo2) {
		this.nIdModulo2 = nIdModulo2;
	}

	public Long getnIdModulo3() {
		return nIdModulo3;
	}

	public void setnIdModulo3(Long nIdModulo3) {
		this.nIdModulo3 = nIdModulo3;
	}

	public Date getdFechaEmision() {
		return dFechaEmision;
	}

	public void setdFechaEmision(Date dFechaEmision) {
		this.dFechaEmision = dFechaEmision;
	}

	public Date getdFechaVencimineto() {
		return dFechaVencimineto;
	}

	public void setdFechaVencimineto(Date dFechaVencimineto) {
		this.dFechaVencimineto = dFechaVencimineto;
	}

	public TcDocentes getTcDocentes() {
		return tcDocentes;
	}

	public void setTcDocentes(TcDocentes tcDocentes) {
		this.tcDocentes = tcDocentes;
	}

	public TcTipoCertificacion getTcTipoCertificacion() {
		return tcTipoCertificacion;
	}

	public void setTcTipoCertificacion(TcTipoCertificacion tcTipoCertificacion) {
		this.tcTipoCertificacion = tcTipoCertificacion;
	}

	public TcModulos getTcModulo1() {
		return tcModulo1;
	}

	public void setTcModulo1(TcModulos tcModulo1) {
		this.tcModulo1 = tcModulo1;
	}

	public TcModulos getTcModulo2() {
		return tcModulo2;
	}

	public void setTcModulo2(TcModulos tcModulo2) {
		this.tcModulo2 = tcModulo2;
	}

	public TcModulos getTcModulo3() {
		return tcModulo3;
	}

	public void setTcModulo3(TcModulos tcModulo3) {
		this.tcModulo3 = tcModulo3;
	}

	
	
	
	
	
}
