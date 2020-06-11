package ar.com.sg.hibernate.domain;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "correos")
public class Correo implements Serializable{
	
	private static final long serialVersionUID = -7868313206178348294L;
	
	//Constructores	
	public Correo() {

	}

	public Correo(String correo) {
		this.correo = correo;
	}
	
	
	//Get y Set	
	public Long getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(Long idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// hashCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((idCorreo == null) ? 0 : idCorreo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Correo other = (Correo) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (idCorreo == null) {
			if (other.idCorreo != null)
				return false;
		} else if (!idCorreo.equals(other.idCorreo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Correo [idCorreo=" + idCorreo + ", correo=" + correo + "]";
	}
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCorreo")
	private Long idCorreo;
	
	@Size(min = 1, max = 50)
	@Column(name = "correo", length = 50)
	private String correo;

}
