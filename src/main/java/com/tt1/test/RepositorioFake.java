package com.tt1.test;

public class RepositorioFake implements IRepositorio{

	private IDBStub db;
	private ToDo tarea; //asi no tengo que comprobar nada del db
	
	public void setTarea(ToDo tarea) {
		this.tarea=tarea;
	}
	
	@Override
	public IDBStub getDb() {
	
		return this.db;
	}

	@Override
	public void setDb(IDBStub db) {
		this.db=db;
		
	}

	@Override
	public ToDo buscarTarea(String nombre) {
		// TODO Auto-generated method stub
		return this.tarea;
	}

	@Override
	public void marcarComoCompletada(String nombre) {
		if(this.tarea!=null && this.tarea.getNombre().equals(nombre)) {
			this.tarea.setCompletado(true);
		}
		
	}

	@Override
	public void insertarTarea(ToDo tarea) {
		
		
	}

	@Override
	public void insertarEmail(String email) {
		
		
	}

}
