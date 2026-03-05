package com.tt1.test;

import java.util.*;

public class DBStub implements IDBStub{
	private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    @Override
    public void guardarTarea(ToDo tarea) { 
    	this.tareas.add(tarea);
    }
    @Override
    public List<ToDo> obtenerTareas() { 
    	return this.tareas;
    }
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
	@Override
	public List<String> getAgendaEmails() {
		return agendaEmails;
	}
	public void setAgendaEmails(List<String> agendaEmails) {
		this.agendaEmails = agendaEmails;
	}
}
