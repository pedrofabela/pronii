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
@Table(name = "TW_ACCESO")
public class TwAcceso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="N_ID")
	@SequenceGenerator(allocationSize = 1, name = "sqTwAcceso", sequenceName = "TW_ACCESO_SEQ")
    @GeneratedValue(generator = "sqTwAcceso", strategy = GenerationType.SEQUENCE)
	private Long nId;
	@Column(name = "S_USUARIOACCESO")
	private String UsuarioAcceso;
	
	@Column(name = "S_NOMBRE")
	private String sNombre;

	public Long getnId() {
		return nId;
	}

	public void setnId(Long nId) {
		this.nId = nId;
	}

	

	public String getUsuarioAcceso() {
		return UsuarioAcceso;
	}

	public void setUsuarioAcceso(String usuarioAcceso) {
		UsuarioAcceso = usuarioAcceso;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	
	

	
	
	
	
	
	

}
