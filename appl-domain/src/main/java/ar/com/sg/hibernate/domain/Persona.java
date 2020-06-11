package ar.com.sg.hibernate.domain;

import java.io.Serializable;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Usuario
 *
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

	private static final long serialVersionUID = -4961130426655782896L;

	public Persona() {

	}

	public Persona(String documento, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String disponibilidadDia, Timestamp dispHoraInicio, Timestamp dispHoraFin,
			LocalDate fechaNacimiento, Date fechaRegistro, Genero genero, EstadoCivil estadoCivil, Localidad localidad,
			List<Direccion> direccion, List<Correo> correo, List<Telefono> telefono, String password,
			Character active) {
		this.documento = documento;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.disponibilidadDia = disponibilidadDia;
		this.dispHoraInicio = dispHoraInicio;
		this.dispHoraFin = dispHoraFin;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.localidad = localidad;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((dispHoraFin == null) ? 0 : dispHoraFin.hashCode());
		result = prime * result + ((dispHoraInicio == null) ? 0 : dispHoraInicio.hashCode());
		result = prime * result + ((disponibilidadDia == null) ? 0 : disponibilidadDia.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((primerApellido == null) ? 0 : primerApellido.hashCode());
		result = prime * result + ((primerNombre == null) ? 0 : primerNombre.hashCode());
		result = prime * result + ((segundoApellido == null) ? 0 : segundoApellido.hashCode());
		result = prime * result + ((segundoNombre == null) ? 0 : segundoNombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Persona other = (Persona) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (dispHoraFin == null) {
			if (other.dispHoraFin != null)
				return false;
		} else if (!dispHoraFin.equals(other.dispHoraFin))
			return false;
		if (dispHoraInicio == null) {
			if (other.dispHoraInicio != null)
				return false;
		} else if (!dispHoraInicio.equals(other.dispHoraInicio))
			return false;
		if (disponibilidadDia == null) {
			if (other.disponibilidadDia != null)
				return false;
		} else if (!disponibilidadDia.equals(other.disponibilidadDia))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (fechaRegistro == null) {
			if (other.fechaRegistro != null)
				return false;
		} else if (!fechaRegistro.equals(other.fechaRegistro))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (primerApellido == null) {
			if (other.primerApellido != null)
				return false;
		} else if (!primerApellido.equals(other.primerApellido))
			return false;
		if (primerNombre == null) {
			if (other.primerNombre != null)
				return false;
		} else if (!primerNombre.equals(other.primerNombre))
			return false;
		if (segundoApellido == null) {
			if (other.segundoApellido != null)
				return false;
		} else if (!segundoApellido.equals(other.segundoApellido))
			return false;
		if (segundoNombre == null) {
			if (other.segundoNombre != null)
				return false;
		} else if (!segundoNombre.equals(other.segundoNombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getDisponibilidadDia() {
		return disponibilidadDia;
	}

	public void setDisponibilidadDia(String disponibilidadDia) {
		this.disponibilidadDia = disponibilidadDia;
	}

	public Timestamp getDispHoraInicio() {
		return dispHoraInicio;
	}

	public void setDispHoraInicio(Timestamp dispHoraInicio) {
		this.dispHoraInicio = dispHoraInicio;
	}

	public Timestamp getDispHoraFin() {
		return dispHoraFin;
	}

	public void setDispHoraFin(Timestamp dispHoraFin) {
		this.dispHoraFin = dispHoraFin;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

	public List<Correo> getCorreo() {
		return correo;
	}

	public void setCorreo(List<Correo> correo) {
		this.correo = correo;
	}

	public List<Telefono> getTelefono() {
		return telefono;
	}

	public void setTelefono(List<Telefono> telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", documento=" + documento + ", primerNombre=" + primerNombre
				+ ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", disponibilidadDia=" + disponibilidadDia + ", dispHoraInicio=" + dispHoraInicio
				+ ", dispHoraFin=" + dispHoraFin + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro="
				+ fechaRegistro + ", genero=" + genero + ", estadoCivil=" + estadoCivil + ", localidad=" + localidad
				+ ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", password="
				+ password + ", active=" + active + "]";
	}

	// Aributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idPersona")
	private Long idPersona;

	@Basic(optional = false)
	@Size(min = 1, max = 11)
	@Column(name = "documento", length = 11, unique = true, nullable = false)
	private String documento;

	@Basic(optional = false)
	@Size(min = 1, max = 50)
	@Column(name = "primerNombre", length = 50, nullable = false)
	private String primerNombre;

	@Size(max = 50)
	@Column(name = "segundoNombre")
	private String segundoNombre;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "primerApellido", length = 50, nullable = false)
	private String primerApellido;

	@Size(max = 50)
	@Column(name = "segundoApellido", length = 50)
	private String segundoApellido;

	@Size(min = 1, max = 100)
	@Column(name = "disponibilidadDia", length = 100)
	private String disponibilidadDia;

	@Basic(optional = false)
	@Column(name = "dispHoraInicio")
	private Timestamp dispHoraInicio;

	@Basic(optional = false)
	@Column(name = "dispHoraFin")
	private Timestamp dispHoraFin;

	@Basic(optional = false)
	@Column(name = "fechaNacimiento")
	private LocalDate fechaNacimiento;

	@Basic(optional = false)
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codGenero", referencedColumnName = "codGenero", nullable = false)
	private Genero genero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codEstadoCivil", referencedColumnName = "codEstadoCivil", nullable = false)
	private EstadoCivil estadoCivil;

	@ManyToOne
	@JoinColumn(name = "codLocalidad", referencedColumnName = "codLocalidad", nullable = false)
	private Localidad localidad;

	@OneToMany
	private List<Direccion> direccion = new ArrayList<Direccion>();

	@OneToMany
	private List<Correo> correo = new ArrayList<Correo>();

	@OneToMany
	private List<Telefono> telefono = new ArrayList<Telefono>();

	@Basic(optional = false)
	@Size(min = 1, max = 20)
	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@Column(name = "active")
	private Character active;

	
	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  
	  @JoinTable( name = "persona_role", joinColumns = {
	  
	  @JoinColumn(name = "idPersona", nullable = false, updatable = false) },
	  inverseJoinColumns = {
	  
	  @JoinColumn(name = "idRole", nullable = false, updatable = false) } ) private
	  Set<Role> roles = new HashSet<Role>(0);
	 
}
