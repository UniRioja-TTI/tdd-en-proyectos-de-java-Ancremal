package com.tt1.test;
/**
 * Clase que actúa como capa de enlace de datos interactuando con el stub.
 */
public class Repositorio implements IRepositorio{
	private IDBStub db;
	
	public Repositorio (IDBStub db) {
		this.db=db;
	}
	/**
	 * Metodo para obtener el {@link IDBStub} que simula la base de datos.
	 * @return el {@link IDBStub} de ese objeto 
	 */
	@Override
	public IDBStub getDb() {
		return db;
	}
	@Override
	public void setDb(IDBStub db) {
		this.db = db;
	}
	/**
	 * Metodo para encontrar una tarea a partir de su nombre 
	 * @param nombre , es el nombre de la tarea que se dea encontrar
	 * @return el objeto {@link ToDo} que tiene ese nombre asociado si existe
	 */
	@Override
	public ToDo buscarTarea(String nombre) { 
		for (ToDo t : db.obtenerTareas()) {
			if (t.getNombre().equals(nombre)) {
				return t;
			}
		}
		return null;
	
	}
	/**
	 * Metodo para cambiar el estado de una tarea {@link ToDo} a completado.
	 * @param nombre El nombre de la tarea que se quiere completar
	 */
	@Override
    public void marcarComoCompletada(String nombre) { 
    	ToDo t=buscarTarea(nombre);
    	if (t!=null) {
    		t.setCompletado(true);
    	}
    
    }
	/**
	 * Metodo para añadir una tarea en la base de datos
	 * @param tarea, es la tarea, objeto {@link ToDo} que se quiere añadir
	 */
	@Override
    public void insertarTarea(ToDo tarea) { 
    	db.guardarTarea(tarea);
    }
	/**
	 * Metodo para añadir un email en la base de datos
	 * @param email, es el email} que se quiere añadir
	 */
	@Override
    public void insertarEmail(String email) { 
    	db.guardarEmail(email);
    }
 }
