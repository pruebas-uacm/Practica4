package mx.edu.uacm.registro.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.registro.domain.Persona;
import mx.edu.uacm.registro.domain.repository.PersonaRepository;
import mx.edu.uacm.registro.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	

	private static final int LOGITUD_MAX = 70;


	public static final Logger log = Logger.getLogger(PersonaServiceImpl.class);
	

	@Autowired
	PersonaRepository personaRepository;
	
	public void agregarPersona(Persona persona) {
		
		if(log.isDebugEnabled())
			log.debug("Estoy entrando al metodo agregarPersona");
		
		if( !(persona.getNombre().length()<=LOGITUD_MAX)) 
		
		personaRepository.save(persona);

	}

	public Persona buscarPersonaXNombre(String nombre) {
		
		if(log.isDebugEnabled())
			log.debug("Entrando al metodo buscarPersonaXNombre");
		
		Persona p = personaRepository.findByNombre(nombre);
		
		return p;
	}

}
