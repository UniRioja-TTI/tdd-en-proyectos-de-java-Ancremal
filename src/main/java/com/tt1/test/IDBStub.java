package com.tt1.test;

import java.util.*;
/**
 * 
 * Interfaz que implementan las clases DBStub y DBStubFAKE
 *
 */
public interface IDBStub {

	  void guardarTarea(ToDo tarea);
	  List<ToDo> obtenerTareas();
	  void guardarEmail(String email);
	  List<ToDo> getTareas();
	  List<String> getAgendaEmails();
	    
	
}
