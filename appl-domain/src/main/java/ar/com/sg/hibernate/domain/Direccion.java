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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable{

	private static final long serialVersionUID = 3601375963996594354L;
	
	//Construtor	
	public Direccion() {

	}

	
	public Direccion(Long idDireccion, String direccion) {
		this.idDireccion = idDireccion;
		this.direccion = direccion;
	}

	public Direccion(@NotNull String direccion) {
		this.direccion = direccion;
	}


	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}


	public void setdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((idDireccion == null) ? 0 : idDireccion.hashCode());
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
		Direccion other = (Direccion) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idDireccion == null) {
			if (other.idDireccion != null)
				return false;
		} else if (!idDireccion.equals(other.idDireccion))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", direccion=" + direccion + "]";
	}



	//Atributo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idDireccion")
	private Long idDireccion;
	
	@NotNull
	@Basic(optional = false)
	@Size(min = 1, max = 100)
	@Column(name = "direccion", length = 100)
	private String direccion;
	
}
