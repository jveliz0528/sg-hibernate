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
@Table(name = "genero")
public class Genero implements Serializable{
	
	private static final long serialVersionUID = -2619788846672762474L;
	
	//Constructores	
	public Genero() {

	}
	
	public Genero(Long idGenero, char codGenero, String genero) {
		this.idGenero = idGenero;
		this.codGenero = codGenero;
		this.Genero = genero;
	}
	
	public Genero(char codGenero) {
		this.codGenero = codGenero;
	}
	
	

	public Genero(char codGenero, String genero) {
		this.codGenero = codGenero;
		this.Genero = genero;
	}

	//Get y Set
	public Long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

	public char getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(char codGenero) {
		this.codGenero = codGenero;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	//hashCode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Genero == null) ? 0 : Genero.hashCode());
		result = prime * result + codGenero;
		result = prime * result + ((idGenero == null) ? 0 : idGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (Genero == null) {
			if (other.Genero != null)
				return false;
		} else if (!Genero.equals(other.Genero))
			return false;
		if (codGenero != other.codGenero)
			return false;
		if (idGenero == null) {
			if (other.idGenero != null)
				return false;
		} else if (!idGenero.equals(other.idGenero))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Genero [idGenero=" + idGenero + ", codGenero=" + codGenero + ", Genero=" + Genero + "]";
	}

	//Atributo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idGenero")
	private Long idGenero;
	
	@Basic(optional = false)
	@Size(min = 1, max = 20)
	@Column(name = "codGenero", length = 20, nullable = false)
	private char codGenero;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "Genero", length = 15, nullable = false)
	private String Genero;

}
