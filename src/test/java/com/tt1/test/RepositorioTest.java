package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepositorioTest {
//TEST DE INTEGRACION en el que comprubeo si la relacion entre las clases es correcta
	/*
	 Para el test unitario debo crear una clase DBStubFake que herede de la misma 
	 interfaz que DBStub (osea tengo que hacer una interfaz de la que hereden lso dos
	 y en el DBSTub implemento los emtodos que nunca den fallo
	 
	 */
	private DBStub db;
	private Repositorio repo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		db=new DBStub();
		repo=new Repositorio(db);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testintersertarYBuscarTarea() {
		
		//Arrange
		ToDo tarea=new ToDo();
		tarea.setNombre("nombre");

		//act
		repo.insertarTarea(tarea);
		
		//Assert
		assertEquals("nombre", repo.buscarTarea("nombre").getNombre());
		
	}
	
	@Test
	void testmarcarComoCompletada() {
		/*
		 *  public void marcarComoCompletada(String nombre) { 
    	ToDo t=buscarTarea(nombre);
    	if (t!=null) {
    		t.setCompletado(true);
    	}
    
		 */
		//Arrange
		ToDo t=new ToDo();
		t.setNombre("nombre");
		t.setCompletado(false);
		
		//act
		repo.insertarTarea(t);
		repo.marcarComoCompletada("nombre");
		
		//Assert
		assertEquals(true, repo.buscarTarea("nombre").getCompletado());
	}
	
	@Test
	void testinsertarEmail() {
		//arrange
		String email="email";
		
		//Act
		repo.insertarEmail(email);
		
		//Assert
		assertEquals(true, db.getAgendaEmails().contains(email));
		assertEquals(1, db.getAgendaEmails().size());
	}

}
