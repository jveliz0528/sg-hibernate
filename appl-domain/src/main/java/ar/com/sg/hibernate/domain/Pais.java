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

import org.hibernate.type.descriptor.java.JavaTypeDescriptorRegistry.FallbackJavaTypeDescriptor;

@Entity
@Table(name = "paises")
public class Pais implements Serializable{

	private static final long serialVersionUID = -7505570024215922380L;
	
	//Constructores
	public Pais() {

	}

	public Pais(String codPais,  String pais) {
		this.codPais = codPais;
		this.pais = pais;
	}

	//Get y set
	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	//HashCode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPais == null) ? 0 : codPais.hashCode());
		result = prime * result + ((idPais == null) ? 0 : idPais.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		Pais other = (Pais) obj;
		if (codPais == null) {
			if (other.codPais != null)
				return false;
		} else if (!codPais.equals(other.codPais))
			return false;
		if (idPais == null) {
			if (other.idPais != null)
				return false;
		} else if (!idPais.equals(other.idPais))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", codPais=" + codPais + ", pais=" + pais + "]";
	}

	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPais")
    private Long idPais;
   
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codPais", length = 20, nullable = false, unique = true)
    private String codPais;
    
	@Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "pais", length = 50, nullable = false)
    private String pais;

}
