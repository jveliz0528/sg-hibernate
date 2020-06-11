/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.sg.hibernate.dao.generic;

import java.io.Serializable;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;


public interface IGenericDAO<Entity, PK extends Serializable> {
	void Guardar(Entity t) throws DuplicateException;

	Entity Buscar(PK id) throws GenericExeption;
	
	void Actualizar(Entity t) throws GenericExeption;


	void Eliminar(Entity t) throws GenericExeption;
}
