package softur.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Calendar;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import softur.entities.Cargo;
import softur.entities.Endereco;
import softur.entities.Funcionario;

public class FuncionarioDAOTest extends DBUnitTest{

	public FuncionarioDAOTest(){
		super();
	}
	
	private void gravaFuncionario(){
		Funcionario f = new Funcionario();
		Cargo cargo = new Cargo("Motorista");
		
		f.setNome("Joao da silva");
		f.setCpf("05894987898");
		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.set(2010, 8, 21);
	//	f.setDataAdmissao(dataEntrada);
				
		f.setEmail("ciclano@gmail.com");
		
		f.setTelefone("22282828");
		
		
 	   Endereco endereco = new Endereco("SC", "Florianopolis", "88786098", "Rua Motta da Silva", "21", "Brasil", "");
		f.setEndereco(endereco);
		f.setCargo(cargo);
		f.setSalario(2000d);
		cargoDao.salvarCargo(cargo);
		funcionarioDao.salvar(f);
	
	
	}
	
	@Test
	public void testFuncionarioDAO() throws SQLException, Exception{
		begin();
		gravaFuncionario();
		close();
		
		// carregamento do estado atual do banco de dados
		IDataSet database = getConnection().createDataSet();
	    ITable tabelaAtual = database.getTable("funcionario");
	    
	    
	    //Carregamento do arquivo de controle funcionario.xml
	    IDataSet dataBaseXML = new FlatXmlDataSetBuilder().build(new FileInputStream(new File("control/funcionario.xml")));
	   
	    ITable tableControle = dataBaseXML.getTable("funcionario");
	    
	    Assertion.assertEquals(tableControle, tabelaAtual);
	}
}
