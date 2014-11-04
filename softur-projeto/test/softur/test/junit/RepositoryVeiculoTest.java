package softur.test.junit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import softur.entities.Veiculo;
import softur.repository.Veiculos;



public class RepositoryVeiculoTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	private Veiculos veiculos;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("softurPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
		this.veiculos = new Veiculos(manager);
		manager.getTransaction().begin();
	}

	@After
	public void tearDown() {
		manager.getTransaction().commit();
		this.manager.close();
	}

	@Test
	public void testSalvar() {
		Veiculo veiculo = new Veiculo();
		veiculo.setBanheiro(true);
		veiculo.setPoltronas(40);
		veiculo.setMarca("Mercedes");
		veiculo.setModelo("�nibus");
		veiculo.setPlaca("MAR-4578");
		veiculo.setChassi("8S89R841TY20U");
		veiculos.salvar(veiculo);

	}

	@Test
	public void testBuscaPorCodigo() {
		Veiculo veiculo = veiculos.buscarId(1L);
		Assert.assertNotNull(veiculo);
	}

	@Test
	public void testListarTodos() {
		List<Veiculo> veiculosList = veiculos.listarTodos();
		for (Veiculo veiculo : veiculosList) {
			System.out.println(veiculo.getId());
		}

	}

	@Test
	public void testDeletar() {
		Veiculo veiculo = veiculos.buscarId(1l);
		try {
			veiculos.deletar(veiculo);
		} catch (PersistenceException e) {
			e.getMessage();
		}
	}

}
