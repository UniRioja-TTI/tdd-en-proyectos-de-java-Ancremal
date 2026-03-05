package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStubFake implements IDBStub{
	private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();
    
    public void setTareas(List <ToDo> tareas) {
    	this.tareas=tareas;
    }
    public void setEmails(List <String> emails) {
    	this.agendaEmails=emails;
    }
    
	@Override
	public void guardarTarea(ToDo tarea) {		
	}

	@Override
	public List<ToDo> obtenerTareas() {
		return this.tareas;
	}

	@Override
	public void guardarEmail(String email) {
		
		
	}

	@Override
	public List<ToDo> getTareas() {
		return this.tareas;
	}

	@Override
	public List<String> getAgendaEmails() {
		return this.agendaEmails;
	}
	

}
