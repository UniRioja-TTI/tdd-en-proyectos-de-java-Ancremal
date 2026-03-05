package com.tt1.test;

public class Repositorio implements IRepositorio{
	private IDBStub db;
	
	public Repositorio (IDBStub db) {
		this.db=db;
	}
	@Override
	public IDBStub getDb() {
		return db;
	}
	@Override
	public void setDb(IDBStub db) {
		this.db = db;
	}
	@Override
	public ToDo buscarTarea(String nombre) { 
		for (ToDo t : db.obtenerTareas()) {
			if (t.getNombre().equals(nombre)) {
				return t;
			}
		}
		return null;
	
	}
	@Override
    public void marcarComoCompletada(String nombre) { 
    	ToDo t=buscarTarea(nombre);
    	if (t!=null) {
    		t.setCompletado(true);
    	}
    
    }
	@Override
    public void insertarTarea(ToDo tarea) { 
    	db.guardarTarea(tarea);
    }
    	
	@Override
    public void insertarEmail(String email) { 
    	db.guardarEmail(email);
    }
 }
