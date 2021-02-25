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
@Table(name = "TW_CERTNIVELIDIOMA")
public class TwNivelIdioma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="N_ID")
	@SequenceGenerator(allocationSize = 1, name = "cerNivel", sequenceName = "TW_CERTNIVELIDIOMA_SEQ")
    @GeneratedValue(generator = "cerNivel", strategy = GenerationType.SEQUENCE)
	private Long nId;
	
	@Column(name = "N_IDDOCENTE")
	private Long nIdDocente;
	
	@Column(name="N_IDTIPOCERTIFICACION")
	private Long nIdTipoCertificacion;
	
	@Column(name="N_IDNIVELIDIOMA")
	private Long nIdNivelIdioma;
	
	@Column(name = "D_FECHAEMISION")
	private Date dFechaEmision;
	
	@Column(name = "D_FECHAVENCIMIENTO")
	private Date dFechaVencimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDDOCENTE", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcDocentes tcDocentes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDTIPOCERTIFICACION", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcTipoCertificacion tcTipoCertificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDNIVELIDIOMA", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcNivelCertificacion tcNivelCertificacion;

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

	public Long getnIdNivelIdioma() {
		return nIdNivelIdioma;
	}

	public void setnIdNivelIdioma(Long nIdNivelIdioma) {
		this.nIdNivelIdioma = nIdNivelIdioma;
	}

	public Date getdFechaEmision() {
		return dFechaEmision;
	}

	public void setdFechaEmision(Date dFechaEmision) {
		this.dFechaEmision = dFechaEmision;
	}

	

	public Date getdFechaVencimiento() {
		return dFechaVencimiento;
	}

	public void setdFechaVencimiento(Date dFechaVencimiento) {
		this.dFechaVencimiento = dFechaVencimiento;
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

	public TcNivelCertificacion getTcNivelCertificacion() {
		return tcNivelCertificacion;
	}

	public void setTcNivelCertificacion(TcNivelCertificacion tcNivelCertificacion) {
		this.tcNivelCertificacion = tcNivelCertificacion;
	}

	@Override
	public String toString() {
		return "TwNivelIdioma [nId=" + nId + ", nIdDocente=" + nIdDocente + ", nIdTipoCertificacion="
				+ nIdTipoCertificacion + ", nIdNivelIdioma=" + nIdNivelIdioma + ", dFechaEmision=" + dFechaEmision
				+ ", dFechaVencimiento=" + dFechaVencimiento + ", tcDocentes=" + tcDocentes + ", tcTipoCertificacion="
				+ tcTipoCertificacion + ", tcNivelCertificacion=" + tcNivelCertificacion + "]";
	}
	
	
	
	
	
	

}
