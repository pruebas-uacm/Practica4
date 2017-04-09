package mx.edu.uacm.registro.test.service;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.registro.Application;
import mx.edu.uacm.registro.domain.Persona;
import mx.edu.uacm.registro.service.PersonaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class PersonaServiceTest {
	
	public static final Logger log = Logger.getLogger(PersonaServiceTest.class);
	
	@Autowired
	PersonaService personaService;
	
	@Test
	public void guardarPersonaServiceTest() {
		
		log.debug("Iniciando metodo guardarPersonaServiceTest");
		
		//System.out.println("Iniciando metodo guardarPersonaServiceTest");
		
		Persona p = new Persona();
		//datos de prueba
		String nombre = "Neymar";
		
		p.setNombre(nombre);
		
		p.setRfc("Messd");
		p.setTotal(new Double("1000.0"));
		
		personaService.agregarPersona(p);
		
		Persona personaEnocontrada = personaService.buscarPersonaXNombre(nombre);
		Assert.assertNotNull(personaEnocontrada);
		
		Assert.assertTrue("La concicion se cumple", nombre.equals(personaEnocontrada.getNombre()));
		
		
	}

}
