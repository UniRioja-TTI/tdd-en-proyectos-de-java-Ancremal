package com.tt1.test;

import java.util.*;
/**
 * Esta clase emula el comportamiento de una base de datos, permitiendo realizar las operaciones
 * que se harían consultando la BD.
 */
public class DBStub implements IDBStub{
	private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    /**
     * Inserta una tarea en la base de datos
     *  @param tarea El objeto {@link ToDo} que se almacena.
     * 
     */
    @Override
    public void guardarTarea(ToDo tarea) { 
    	this.tareas.add(tarea);
    }
    /**
     * Devuelve todas lñas tareas almacenadas 
     * @return La lista de tareas de la BD.
     */
    @Override
    public List<ToDo> obtenerTareas() { 
    	return this.tareas;
    }
    /**
     * almacena email  en la lista de emails del objeto
     * @param email El objeto {@link String} que se almacena.
     */
    @Override
    public void guardarEmail(String email) { 
    	this.agendaEmails.add(email);
    }
    
    @Override
	public List<ToDo> getTareas() {
		return tareas;
	}
	public void setTareas(List<ToDo> tareas) {
		this.tareas = tareas;
	}
	/**
     * Devuelve todas los emails almacenados
     * @return La lista de emails de la BD.
     */
	@Override
	public List<String> getAgendaEmails() {
		return agendaEmails;
	}
	public void setAgendaEmails(List<String> agendaEmails) {
		this.agendaEmails = agendaEmails;
	}
}
