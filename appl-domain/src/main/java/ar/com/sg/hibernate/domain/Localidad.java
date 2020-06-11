package ar.com.sg.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.type.descriptor.java.JavaTypeDescriptorRegistry.FallbackJavaTypeDescriptor;

@Entity
@Table(name = "localidades")
public class Localidad implements Serializable{

	private static final long serialVersionUID = -6200424915453260676L;
	
	//Constructores
	public Localidad() {

	}

	public Localidad(String codLocalidad, String localidad) {
		this.codLocalidad = codLocalidad;
		this.localidad = localidad;
	}
	

	public Localidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}
	
	//Get y set
	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getCodLocalidad() {
		return codLocalidad;
	}

	public void setCodLocalidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	//HashCode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLocalidad == null) ? 0 : codLocalidad.hashCode());
		result = prime * result + ((idLocalidad == null) ? 0 : idLocalidad.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
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
		Localidad other = (Localidad) obj;
		if (codLocalidad == null) {
			if (other.codLocalidad != null)
				return false;
		} else if (!codLocalidad.equals(other.codLocalidad))
			return false;
		if (idLocalidad == null) {
			if (other.idLocalidad != null)
				return false;
		} else if (!idLocalidad.equals(other.idLocalidad))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", codLocalidad=" + codLocalidad + ", localidad=" + localidad
				+ "]";
	}



	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLocalidad")
    private Integer idLocalidad;
   
	@Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "codLocalidad", length = 20, nullable = false)
    private String codLocalidad;
    
	@Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "localidad", length = 100, nullable = false)
    private String localidad;
   
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
    @ManyToOne(optional = false)
    private Estado estado;

}
