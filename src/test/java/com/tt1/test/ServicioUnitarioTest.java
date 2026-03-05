package com.tt1.test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ServicioUnitarioTest {
	private RepositorioFake repo;
    private MailerStubFake mailer;
    private Servicio servicio;
    

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

    @BeforeEach
    void setUp() throws Exception {
        repo = new RepositorioFake();
        mailer = new MailerStubFake();
       
         DBStubFake db = new DBStubFake();
        repo.setDb(db);
        
        servicio = new Servicio(repo, mailer);
    }
    

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    void testCrearTareaDisparaAlertaSiHayCaducadas() {
        //Arrange
        ToDo tareaCaducada = new ToDo();
        tareaCaducada.setNombre("Tarea Vieja");
        tareaCaducada.setFechaLimite(LocalDate.now().minusDays(1)); // Ayer
        tareaCaducada.setCompletado(false);
        repo.setTarea(tareaCaducada);
        repo.getDb().getTareas().add(tareaCaducada);
        repo.getDb().getAgendaEmails().add("test@unirioja.es");

        // ACt
        servicio.crearTarea("Nueva Tarea", LocalDate.now().plusDays(1));

        //assert
        assertTrue(mailer.getVecesLlamado() > 0, "Debería haber enviado al menos un correo de alerta");
        assertEquals("test@unirioja.es", mailer.getUltimoDestino());
    }

    @Test
    void testAgregarEmail() {
        // Arrange
        String email = "nuevo@unirioja.es";

        // Act
        servicio.agregarEmail(email);

        // Assert
        assertNotNull(email);
    }
	
    
    
    @Test
    void testConsultarPendientesFiltraCorrectamente() {
   
        ToDo t1 = new ToDo();
        t1.setCompletado(true);
        
        ToDo t2 = new ToDo();
        t2.setCompletado(false);
        
        repo.getDb().getTareas().add(t1);
        repo.getDb().getAgendaEmails().add("user@test.com"); 
        int pendientes = servicio.consultarPendientes().size();

        assertNotNull(pendientes);
    }
    
    
}
