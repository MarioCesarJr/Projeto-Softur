package softur.test.dbunit;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        
		Endereco endereco = new Endereco("SC", "Florianopolis", "88786098", "Rua Motta da Silva", "21", "estreito", "Brasil");
		
		Cargo cargo = new Cargo();
		
		cargo.setNomeCargo("Motorista");
		
		cargos.salvar(cargo);
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCargo(cargo);
		
		funcionario.setNome("Ciclano da Silva");
		
		funcionario.setCpf("05894987898");
		
		funcionario.setComplemento("complemento");
		
		funcionario.setNumeroCNH("22222232");
		
		funcionario.setEndereco(endereco);
		
        Date data = new Date();
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			data = formatarData.parse("11/12/2012");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		funcionario.setDataAdmissao(data);
				
		funcionario.setEmail("ciclano@gmail.com");
		
		funcionario.setTelefone("22282828");
		
		funcionario.setSalario(2000d);

		funcionarios.salvar(funcionario);
	
	
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
