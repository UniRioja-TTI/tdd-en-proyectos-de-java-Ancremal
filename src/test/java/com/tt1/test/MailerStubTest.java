package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailerStubTest {
	private MailerStub ms;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ms=new MailerStub();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testenviarCorreo() {
		//Arrange
		String destino="destino";
		String mensaje="Hola hola";
		//act
		Boolean bool=ms.enviarCorreo(destino, mensaje);
		
		//Assert
		assertEquals(true, bool);
		
	}

}
