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

import softur.entities.Cargo;
import softur.entities.Endereco;
import softur.entities.Funcionario;
import softur.repository.Funcionarios;

public class RepositoryFuncionarioTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	private Funcionarios funcionarios;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("softurPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
		this.funcionarios = new Funcionarios(manager);
		manager.getTransaction().begin();
	}

	@After
	public void tearDown() {
		manager.getTransaction().commit();
		this.manager.close();
	}

	@Test
	public void testSalvar() {
		Endereco endereco = new Endereco("SC", "Florianopolis", "88786098",
				"Rua Motta da Silva", "21", "estreito", "Brasil");

		Cargo cargo = new Cargo();
		cargo.setId(1L);

		Funcionario funcionario = new Funcionario();

		funcionario.setCargo(cargo);

		funcionario.setNome("Ciclano da Silva");

		funcionario.setCpf("05894987898");

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
	public void testBuscaPorCodigo(){
		Funcionario funcionario = funcionarios.buscarId(1L);
		System.out.println(funcionario.getNome());
	}
	
	@Test
	public void testListarTodos(){
		List<Funcionario> funcionariosList = funcionarios.listarTodos();
		for (Funcionario funcionario : funcionariosList) {
			System.out.println(funcionario.getNome());
		}
	}
	
	@Test
	public void testDeletar(){
		Funcionario funcionario = funcionarios.buscarId(17L);
		try{
			funcionarios.deletar(funcionario);
		}catch(PersistenceException e){
          e.getMessage();
	}

	}
}