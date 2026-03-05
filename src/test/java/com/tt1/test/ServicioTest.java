package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioTest {

	private DBStub db;
	private Repositorio repo;
	private MailerStub mailer;
	private Servicio servicio;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		db= new DBStub();
		repo= new Repositorio(db);
		mailer= new MailerStub();
		servicio=new Servicio(repo, mailer);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    void testCrearTareaYConsultarPendientes() {
        // Arrange
        String nombre = "Estudiar Maven";
        LocalDate fecha = LocalDate.now().plusDays(1);

        // Act
        servicio.crearTarea(nombre, fecha);
        
        //Assert
        assertEquals(1, servicio.consultarPendientes().size());
        assertEquals(nombre, servicio.consultarPendientes().get(0).getNombre());
    }
	
	@Test
    void testAlertaEnvioCorreo() {
        // Arrange
        db.guardarEmail("profe@unirioja.es");
        
        ToDo caducada = new ToDo();
        caducada.setNombre("Tarea Antigua");
        caducada.setFechaLimite(LocalDate.now().minusDays(5)); // Fecha pasada
        caducada.setCompletado(false);
        db.guardarTarea(caducada);

        // Act
        servicio.consultarPendientes();

        // Assert
        assertFalse(servicio.consultarPendientes().isEmpty());
    }
}
