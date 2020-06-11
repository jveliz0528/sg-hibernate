package ar.com.sg.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1315598113120335924L;

	// Constructores
	public Estado() {

	}

	public Estado(String codEstado, String estado) {
		this.codEstado = codEstado;
		this.estado = estado;
	}

	// Get y Set
	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	//hashCode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEstado == null) ? 0 : codEstado.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Estado other = (Estado) obj;
		if (codEstado == null) {
			if (other.codEstado != null)
				return false;
		} else if (!codEstado.equals(other.codEstado))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", codEstado=" + codEstado + ", estado=" + estado + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idEstado")
	private Long idEstado;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "codEstado",length = 20, unique = true, nullable = false)
	private String codEstado;

	@Basic(optional = false)
	@Size(min = 1, max = 50)
	@Column(name = "estado", length = 50, nullable = false)
	private String estado;

	@ManyToOne(optional = false)
	@JoinColumn(name = "codPais", referencedColumnName = "codPais")
	private Pais pais;

}
