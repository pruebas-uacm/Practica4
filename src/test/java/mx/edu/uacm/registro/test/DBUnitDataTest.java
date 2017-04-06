package mx.edu.uacm.registro.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.registro.Application;
import mx.edu.uacm.registro.util.DBUnitData;

import javax.sql.DataSource;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
import java.io.FileNotFoundException;
import java.io.IOException;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class DBUnitDataTest {
	
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void extraerDatasetsTest()  throws SQLException, DatabaseUnitException, FileNotFoundException, IOException {
		
		DBUnitData.extraerDatasetsUnoxUno(dataSource.getConnection());
		
	}
	
}