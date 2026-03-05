package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tt1.test.*;

class ToDoTest {

	private ToDo todo; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		todo= new ToDo();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//Arrange
		String nombreesp="todo1";
		String descripcionesp="descripcion";
		java.time.LocalDate fechaesp=java.time.LocalDate.now();
		Boolean completoesp=true;
		//Act donde de eejcutan los metodos del ToDo
		todo.setNombre(nombreesp);
		todo.setDescripcion(descripcionesp);
		todo.setFechaLimite(fechaesp);
		todo.setCompletado(completoesp);
		//assert para comrprobar que han actuado bien
		assertEquals(nombreesp, todo.getNombre());
		assertEquals(descripcionesp, todo.getDescripcion());
		assertEquals(fechaesp, todo.getFechaLimite());
		assertEquals(completoesp, todo.getCompletado());

	}

}
