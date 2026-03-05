package com.tt1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositorioUnitarioTest {
	private DBStubFake db;
	private Repositorio repo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		db=new DBStubFake();
		repo=new Repositorio(db);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testBuscarTarea() {
		//Arrange
		ToDo tarea=new ToDo();
		tarea.setNombre("nombre");
		List <ToDo> lista=new ArrayList();
		lista.add(tarea);
		db.setTareas(lista);
		
		//ACT
		ToDo res=repo.buscarTarea("nombre");
		
		//Assert
		assertNotNull(res);
		assertEquals("nombre", res.getNombre());
	}
	
	@Test
	void testInsertarTarea() {
		
		//Arrange
		ToDo tarea=new ToDo();
		tarea.setNombre("nombre");
		

		//act
		
		repo.insertarTarea(tarea);
		
		//Assert
		assertNotNull(tarea);
	}
	
	@Test
	void testmarcarComoCompletada() {
		
		//Arrange
		ToDo t=new ToDo();
		t.setNombre("nombre");
		t.setCompletado(false);
		
		List<ToDo> lista=new ArrayList();
		lista.add(t);
		db.setTareas(lista);
		
		//act
		repo.marcarComoCompletada("nombre");
		
		//Assert
		assertEquals(true, t.getCompletado());
	}
	
	@Test
	void testinsertarEmail() {
		//arrange
		String email="email";
		
		//Act
		repo.insertarEmail(email);
		
		//Assert
		assertNotNull(email);
	}

}
