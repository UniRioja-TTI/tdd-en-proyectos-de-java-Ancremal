package com.tt1.test;

import java.time.LocalDate;
import java.util.*;
/**
 * Clase que representa la lógica de negocio y la interfaz de operaciones para el usuario.
 * Es la clase que se relaciona con Repositorio, el sistema de envío de emails y las tareas.
 */
public class Servicio {
	private IRepositorio repo;
	private IMailerStub mailer;
	
	public Servicio(IRepositorio repo, IMailerStub mailer) {
		this.repo=repo;
		this.mailer=mailer;
	}
	/**
	 * metodo para crear una tarea nueva que se almacena en la base de datos
	 * @param nombre El nombre de la tarea a añadir
	 * @param fecha Objeto {@link java.time.LocalDate} que indica el plazo de la tarea.
	 */
	public void crearTarea(String nombre, java.time.LocalDate fecha) { 
		comprobarAlertas();
		ToDo nueva= new ToDo();
		nueva.setNombre(nombre);
		nueva.setFechaLimite(fecha);
		nueva.setCompletado(false);
		repo.insertarTarea(nueva);
	}
	 /**
	  * metodo para añadir un email a la base de datos
	  * @param email el email a añadir
	  */
    public void agregarEmail(String email) { 
		comprobarAlertas();
		repo.insertarEmail(email);

    }
    public void finalizarTarea(String nombre) { 
    	
    }
    /**
     * Metodo para obtener las tareas que no estan completadas. 
     * @return la lista de tareas, {@link ToDo} que están sin completar
     */
    public List<ToDo> consultarPendientes() { 
    	comprobarAlertas();
    	List<ToDo> pendientes=new ArrayList<>();
    	for (ToDo t : repo.getDb().obtenerTareas()) {
    		if(!t.getCompletado()) {
    			pendientes.add(t);
    		}
    	}
    	return pendientes;
    }
    /**
     * Método para enviar correo a los emails asociados a tareas que no estén completadas y que haya 
     * vencido su fecha limite.
     */
    private void comprobarAlertas() { 
    	for (ToDo t : repo.getDb().obtenerTareas()) {
    		if (!t.getCompletado() && t.getFechaLimite().isBefore(LocalDate.now())){
    			for (String email : repo.getDb().getAgendaEmails()) {
    				mailer.enviarCorreo(email, "Alerta: " + t.getNombre() + "Ha cadiucado");
    			}
    		}
    	}
    }

	public IRepositorio getRepo() {
		return repo;
	}

	public void setRepo(IRepositorio repo) {
		this.repo = repo;
	}

	public IMailerStub getMailer() {
		return mailer;
	}

	public void setMailer(IMailerStub mailer) {
		this.mailer = mailer;
	}
}
