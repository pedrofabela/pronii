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
@Table(name = "PERFILES")
public class Perfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(allocationSize = 1, name = "perfiles", sequenceName = "PERFILES_SEQ")
    @GeneratedValue(generator = "perfiles", strategy = GenerationType.SEQUENCE)
	private Long nId;
	
	@Column(name = "PERFIL")
	private String Perfil;

	public Long getnId() {
		return nId;
	}

	public void setnId(Long nId) {
		this.nId = nId;
	}

	public String getPerfil() {
		return Perfil;
	}

	public void setPerfil(String perfil) {
		Perfil = perfil;
	}

	@Override
	public String toString() {
		return "Perfil [nId=" + nId + ", Perfil=" + Perfil + "]";
	}
	
	

}
