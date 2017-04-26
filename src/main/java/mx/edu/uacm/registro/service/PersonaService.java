package mx.edu.uacm.registro.service;

import mx.edu.uacm.registro.domain.Persona;

public interface PersonaService {
	
	
	String agregarPersona(Persona persona);
	
	Persona buscarPersonaXNombre(String nombre);

}
