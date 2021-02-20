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
@Table(name = "TW_CENNI")
public class TwCenni implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="N_ID")
	@SequenceGenerator(allocationSize = 1, name = "secuencia", sequenceName = "TW_CENNI_SEQ")
    @GeneratedValue(generator = "secuencia", strategy = GenerationType.SEQUENCE)
	private Long nId;
	
	@Column(name = "N_IDDOCENTE")
	private Long nIdDocente;
	
	@Column(name = "N_IDNIVELIDIOMA")
	private Long nIdNivelIdioma;
	
	@Column(name = "D_FECHAEMISION")
	private Date dFechaEmision;
	
	@Column(name = "D_FECHAVENCIMIENTO")
	private Date dFechaVencimineto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_IDDOCENTE", referencedColumnName = "N_ID", updatable = false, insertable = false)
	private TcDocentes tcDocentes;
	
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

	public TcNivelCertificacion getTcNivelCertificacion() {
		return tcNivelCertificacion;
	}

	public void setTcNivelCertificacion(TcNivelCertificacion tcNivelCertificacion) {
		this.tcNivelCertificacion = tcNivelCertificacion;
	}
	
	
	
	

}
