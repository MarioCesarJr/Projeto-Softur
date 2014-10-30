package softur.test.dbunit;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.EntityManager;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import softur.repository.infra.FuncionariosHibernate;
import softur.util.JpaUtil;

public class DBUnitTest extends DBTestCase {
	
	private EntityManager entityManager;
	public FuncionariosHibernate funcionarioDao;

	
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
	
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception{ 
		return DatabaseOperation.CLEAN_INSERT;
	}

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
    	return DatabaseOperation.DELETE_ALL;
    }	
		
	public void begin(){
		JpaUtil.initFactory();
		entityManager = JpaUtil.createEntityManager();
		entityManager.getTransaction().begin();
	//	cargoDao = new CargoDAO(entityManager);	
		funcionarioDao = new FuncionariosHibernate(entityManager);
	}
	
	public void close(){
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager = null;
	//	cargoDao = null;
		JpaUtil.closeFactory();
	}
}
