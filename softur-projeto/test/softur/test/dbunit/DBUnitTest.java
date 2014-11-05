package softur.test.dbunit;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import softur.repository.Cargos;
import softur.repository.Funcionarios;

public class DBUnitTest extends DBTestCase {
	
	private static EntityManagerFactory factory;
	private EntityManager entityManager;
	public Funcionarios funcionarios;
    public Cargos cargos;
	
	public DBUnitTest() {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/softur_db");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "host");
		
	}

	@Override  // Carregar base de dados
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream(new File("input/dbZerado.xml")));
	}
	
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception{ 
		return DatabaseOperation.INSERT;
	}

	
    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
    	return DatabaseOperation.NONE;
    }	
		
	public void begin(){
		factory = Persistence.createEntityManagerFactory("softurPU");
		this.entityManager = factory.createEntityManager();
		funcionarios = new Funcionarios(entityManager);
		cargos = new Cargos(entityManager);
		entityManager.getTransaction().begin();	
		
	}
	
	public void close(){
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager = null;
	    factory.close();
	}
}
