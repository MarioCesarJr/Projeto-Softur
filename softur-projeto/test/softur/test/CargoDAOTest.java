package softur.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import softur.entities.Cargo;

public class CargoDAOTest extends DBUnitTest {

	public CargoDAOTest() {
		super();
	}

	private void gravaCargo() {
		Cargo cargo = new Cargo();
		cargo.setNomeCargo("Motorista");
		cargoDao.salvarCargo(cargo);
		
		
	}

	@Test
	public void testCargoDao() throws SQLException, Exception {
		begin();
		gravaCargo();
		close();

		// Carregamento do estado atual do banco de dados.
		IDataSet dataBase = getConnection().createDataSet();
		ITable tabelaAtual = dataBase.getTable("cargo");

		// Carregamento do arquivo de controle (banda.xml)
		IDataSet dataBaseXML = new FlatXmlDataSetBuilder()
				.build(new FileInputStream(new File("control/cargo.xml")));
		ITable tabelaControle = dataBaseXML.getTable("cargo");

		Assertion.assertEquals(tabelaControle, tabelaAtual);

	}

}
