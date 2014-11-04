package softur.test.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import softur.entities.Cliente;
import softur.entities.Endereco;
import softur.entities.Funcionario;
import softur.repository.Clientes;



public class RepositoryClienteTest {
	
	private static EntityManagerFactory factory;
	private EntityManager manager;
	private Clientes clienteRep;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("softurPU");
	}
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
		this.clienteRep = new Clientes(manager);
		manager.getTransaction().begin();
	}
   
	@After
	public void tearDown() {
		manager.getTransaction().commit();
		this.manager.close();
	}
	
	@Test
	public void testSalvar(){
		
		Endereco endereco = new Endereco("SP", "São Paulo", "34786088",
				"Rua Tita Dentes", "28", "Ipiranga", "Brasil");
		
		Cliente c = new Cliente();
		c.setCpf("25123685214");
		
		Date dataCadastro = new Date();
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dataCadastro = formatarData.parse("11/12/2012");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setDataCadastro(dataCadastro);
		c.setEmail("fulano@bol.com.br");
		c.setEndereco(endereco);
		c.setNome("Fulano");
		c.setTelefone("4830257623");
	}
	
	@Test
	public void testBuscaPorCodigo(){
		Cliente clienteEnt = clienteRep.buscarId(1L);
		System.out.println(clienteEnt.getNome());
	}
	
	@Test
	public void testListarTodos(){
		List<Cliente> clientesList = clienteRep.listarTodos();
		for (Cliente clienteEnt : clientesList) {
			System.out.println(clienteEnt.getNome());
		}
	}
	
	@Test
	public void testDeletar(){
		Cliente clienteEnt = clienteRep.buscarId(1L);
		try{
			clienteRep.deletar(clienteEnt);
		}catch(PersistenceException e){
          e.getMessage();
	}

	}
}
