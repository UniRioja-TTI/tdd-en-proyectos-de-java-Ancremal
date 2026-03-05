package com.tt1.test;

public interface IRepositorio {
	public IDBStub getDb();
	public void setDb(IDBStub db);
	public ToDo buscarTarea(String nombre);
    public void marcarComoCompletada(String nombre);
    public void insertarTarea(ToDo tarea);
    	
    public void insertarEmail(String email) ;
}
