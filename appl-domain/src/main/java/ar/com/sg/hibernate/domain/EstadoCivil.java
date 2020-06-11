package ar.com.sg.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estadoCivil")
public class EstadoCivil implements Serializable{
	
	private static final long serialVersionUID = -6269079330670304906L;
	
	//Constructores	
	public EstadoCivil() {

	}

	public EstadoCivil(char codEstadoCivil, String estadoCivil) {
		this.codEstadoCivil = codEstadoCivil;
		this.estadoCivil = estadoCivil;
	}

	public EstadoCivil(char codEstadoCivil) {
		this.codEstadoCivil = codEstadoCivil;
	}
	
	//Get y Set
	public Long getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(Long idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public char getCodEstadoCivil() {
		return codEstadoCivil;
	}

	public void setCodEstadoCivil(char codEstadoCivil) {
		this.codEstadoCivil = codEstadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	//hashCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codEstadoCivil;
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((idEstadoCivil == null) ? 0 : idEstadoCivil.hashCode());
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
		EstadoCivil other = (EstadoCivil) obj;
		if (codEstadoCivil != other.codEstadoCivil)
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (idEstadoCivil == null) {
			if (other.idEstadoCivil != null)
				return false;
		} else if (!idEstadoCivil.equals(other.idEstadoCivil))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "EstadoCivil [idEstadoCivil=" + idEstadoCivil + ", codEstadoCivil=" + codEstadoCivil + ", estadoCivil="
				+ estadoCivil + "]";
	}

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idEstadoCivil")
	private Long idEstadoCivil;
	
	@Basic
	@Size(max = 1)
	@Column(name = "codEstadoCivil", length = 1, nullable = false)
	private char codEstadoCivil;
	
	@Basic(optional = false)
	@Size(min = 1, max = 15)
	@Column(name = "estadoCivil",length = 15, nullable = false)
	private String estadoCivil;

}
