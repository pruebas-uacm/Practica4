package mx.edu.uacm.registro.test.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.registro.Application;
import mx.edu.uacm.registro.domain.Factura;
import mx.edu.uacm.registro.domain.Persona;
import mx.edu.uacm.registro.domain.repository.FacturaRepository;
import mx.edu.uacm.registro.domain.repository.PersonaRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class PersonaTest {
	
	public static final Logger log = Logger.getLogger(PersonaTest.class);
	
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	DataSource dataSource;
	
	@After
	public  void configurar() throws SQLException, DatabaseUnitException, FileNotFoundException, IOException {
		
		Connection conn = dataSource.getConnection();
		IDatabaseConnection connection = new DatabaseConnection(conn);
		DatabaseConfig dbConfig = connection.getConfig();
		 dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		 FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		 
		 IDataSet dataSetFactura = builder.build(new File(System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "datasets/factura.xml"));
		 
		 IDataSet dataSetPersona = builder.build(new File(System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "datasets/persona.xml"));
		 
		 DatabaseOperation.INSERT.execute(connection, dataSetFactura);
		 
	}
	
	@Test
	public void insertarPersonaTest(){
		
		log.debug("Entrando al metodo insertarPersonaTest");
		
	}

}
