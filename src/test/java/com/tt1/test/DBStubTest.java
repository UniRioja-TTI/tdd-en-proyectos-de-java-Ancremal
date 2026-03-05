package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBStubTest {
//
	private DBStub db;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		db=new DBStub();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGuardarTarea() {
		/*
		 * public void guardarTarea(ToDo tarea) { 
    	this.tareas.add(tarea);
    }
		 */
		//Arrange
		ToDo t=new ToDo();
		t.setNombre("nombre");
		//Act
		db.guardarTarea(t);
		
		//assert
		assertEquals(1, db.getTareas().size());
		assertEquals("nombre", db.getTareas().get(0).getNombre());
		assertEquals(t, db.getTareas().get(0));
	}
	@Test
	void testobtenerTareas()
	{
		//Arrange
		ToDo t=new ToDo();
		t.setNombre("nombre");
		
		//Act y assert para la vacía
		List<ToDo> listavacia=db.obtenerTareas();
		assertEquals(0, listavacia.size());
		
		//Act para la no vacía
		db.guardarTarea(t);
		List<ToDo> listanovacia=db.obtenerTareas();
		//assert  para la no vacía
		assertEquals(1, listanovacia.size());
		assertEquals("nombre", listanovacia.get(0).getNombre());
		assertEquals(t, listanovacia.get(0));
		
	}
	@Test
	void testguardarEmail() {
		//Arrange
		String email="correo";
		//act
		db.guardarEmail(email);
		//Assert
		assertEquals(1, db.getAgendaEmails().size());
		assertEquals(email, db.getAgendaEmails().get(0));
	}
	
	
	
	

}
