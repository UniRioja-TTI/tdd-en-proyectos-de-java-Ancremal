package com.tt1.test;

import java.time.LocalDate;
import java.util.*;

public class Servicio {
	private IRepositorio repo;
	private IMailerStub mailer;
	
	public Servicio(IRepositorio repo, IMailerStub mailer) {
		this.repo=repo;
		this.mailer=mailer;
	}
	
	public void crearTarea(String nombre, java.time.LocalDate fecha) { 
		comprobarAlertas();
		ToDo nueva= new ToDo();
		nueva.setNombre(nombre);
		nueva.setFechaLimite(fecha);
		nueva.setCompletado(false);
		repo.insertarTarea(nueva);
	}
	
    public void agregarEmail(String email) { 
		comprobarAlertas();
		repo.insertarEmail(email);

    }
    public void finalizarTarea(String nombre) { 
    	
    }
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
