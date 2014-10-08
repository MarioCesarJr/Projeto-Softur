package softur.test;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.EntityManager;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import softur.dao.CargoDAO;
import softur.dao.FuncionarioDAO;
import softur.util.JpaUtil;

public class DBUnitTest extends DBTestCase {
	
	private EntityManager entityManager;
	public FuncionarioDAO funcionarioDao;
	public CargoDAO cargoDao;

	
	public DBUnitTest() {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/softur_db");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
		
	}

	@Override  // Carregar base de dados
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream(new File("input/dbZerado.xml")));
	}
	
	protected DatabaseOperation getsetDatabaseOperation() throws Exception{
		return DatabaseOperation.INSERT;
	}
	
	public void begin(){
		entityManager = JpaUtil.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	public void close(){
		entityManager.getTransaction().commit();
		entityManager.close();
		JpaUtil.closeFactory();
	}
}
