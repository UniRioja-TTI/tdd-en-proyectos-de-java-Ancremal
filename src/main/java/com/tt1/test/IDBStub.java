package com.tt1.test;

import java.util.*;

public interface IDBStub {

	  void guardarTarea(ToDo tarea);
	  List<ToDo> obtenerTareas();
	  void guardarEmail(String email);
	  List<ToDo> getTareas();
	  List<String> getAgendaEmails();
	    
	
}
