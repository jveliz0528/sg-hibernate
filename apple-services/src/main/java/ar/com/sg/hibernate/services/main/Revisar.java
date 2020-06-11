package ar.com.sg.hibernate.services.main;

import java.sql.Timestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.*;
import ar.com.sg.hibernate.services.impl.*;

public class Revisar {
	/**
	 * @param args
	 * @throws GenericExeption
	 * @throws DuplicateException
	 */
	public static void main(String[] args) throws GenericExeption, DuplicateException {
	       PersonaServiceImpl us=new PersonaServiceImpl();
	       PaisServiceImpl ps = new PaisServiceImpl();
	       GeneroServiceImpl g = new GeneroServiceImpl();
	       EstadoServiceImpl es = new EstadoServiceImpl();
	       EstadoCivilServiceImpl ec = new EstadoCivilServiceImpl();
	       DireccionServiceImpl ds=new DireccionServiceImpl();
	       LocalidadServiceImpl l=new LocalidadServiceImpl();
	       CorreoServiceImpl e=new CorreoServiceImpl();
	       RoleServiceImpl rs=new RoleServiceImpl();
	       TelefonoServiceImpl t = new TelefonoServiceImpl();
	        	     
	        Persona p = new Persona();   
	        
	        //Pais
	        Pais c = new Pais("AR", "Agentina");
	        ps.GuardarPais(c);
	  
	        Estado miEstado = new Estado("BA-02", "Buenos Aires");
	        //es.GuardarEstado(miEstado);
	        
	        Genero miGenero = new Genero('M', "Maculino");	 
	       // g.GuardarGenero(miGenero);

	        EstadoCivil miEstadoCivil = new EstadoCivil('S', "Soltero");
	        //ec.GuardarEstadoCivil(miEstadoCivil);
	        
	        //Localidad
	        Localidad miLocalidad = new Localidad("BA-002", "3 de Febrero");
	       // l.GuardarLocalidad(miLocalidad);
	        
	        //Correo
	        Correo miCorreo= new Correo("jevliz@gmail.com");
	        e.GuardarCorreo(miCorreo);
	        
	        //Telefono
	        Telefono miTelefono = new Telefono("1169310363");
	        t.GuardarTelefono(miTelefono);
	        
	        //Direccion
	        Direccion miDireccion= new Direccion("Calle 5");
	        ds.GuardarDireccion(miDireccion);
	        
			long time = 0;
			Timestamp t1= new Timestamp(time);
	        
			Timestamp t2= new Timestamp(time);
			
			//Role
			Role miRole = new Role("ADMIN", "Administrador");  
			rs.GuardarRole(miRole);
			
			//p.setidPersona((long) 25);
	        p.setDocumento("808080");
	        p.setPrimerNombre("Jesus");
	        p.setSegundoNombre("");
	        p.setPrimerApellido("Veliz");
	        p.setSegundoApellido("");
	        p.setDisponibilidadDia("Lunes-Juevez");
	        p.setDispHoraFin(t1);
	        p.setDispHoraInicio(t2);
	        p.setFechaNacimiento(LocalDate.of(1986, 5, 27));
	        p.setFechaRegistro(new Date());
	        p.setPassword("1234");
	        
	        //Correo
	        p.getCorreo().add(miCorreo);
	        
	        //Direccion
	        p.getDireccion().add(miDireccion);
	        
	        //Telefono
	        p.getTelefono().add(miTelefono);
	       
	        //Genero
	        p.setGenero(miGenero);
	        
	        //Estado Civil
	        p.setEstadoCivil(miEstadoCivil);
	        
	        //Localidad
	        p.setLocalidad(miLocalidad);
	  
	       us.GuardarPersona(p);
	}

}
