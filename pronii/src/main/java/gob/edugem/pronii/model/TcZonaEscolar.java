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
@Table(name = "TC_ZONAESCOLAR")
public class TcZonaEscolar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "N_ID")
	@SequenceGenerator(allocationSize = 1, name = "sqTcZonaEscolar", sequenceName = "TC_ZONAESCOLAR_SEQ")
    @GeneratedValue(generator = "sqTcZonaEscolar", strategy = GenerationType.SEQUENCE)
	private Long nId;
	@Column(name = "S_NOMBRE")
	private String sNombre;
	@Column(name = "ESTATUS")
	private Integer nEstatus;
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
	public Integer getnEstatus() {
		return nEstatus;
	}
	public void setnEstatus(Integer nEstatus) {
		this.nEstatus = nEstatus;
	}
	
}
