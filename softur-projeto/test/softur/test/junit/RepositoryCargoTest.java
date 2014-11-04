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

import softur.entities.Cargo;
import softur.repository.Cargos;

public class RepositoryCargoTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	private Cargos cargos;
	
	@BeforeClass
	public static void init(){
		factory = Persistence.createEntityManagerFactory("softurPU");
	}
	
	@Before
	public void setUp(){
		this.manager = factory.createEntityManager();
		this.cargos = new Cargos(manager);
		manager.getTransaction().begin();
	}
	
	@After
	public void tearDown(){
		manager.getTransaction().commit();
		this.manager.close();
	}
	
	@Test
	public void testSalvar(){
		Cargo cargo = new Cargo();
		cargo.setNomeCargo("Motorista");
		cargos.salvar(cargo);

	}
	
	@Test
	public void testBuscaPorCodigo(){
		Cargo cargo = cargos.buscarPorCodigo(1L);
		Assert.assertNotNull(cargo);
	}
	
	@Test
	public void testListarTodos(){
		List<Cargo> cargosList = cargos.listarTodos();
	    for (Cargo cargo : cargosList) {
			System.out.println(cargo.getNomeCargo());
		}
	
	}
	
	@Test
	public void testDeletar(){
		Cargo cargo = cargos.buscarPorCodigo(21L);
		try{
		cargos.deletar(cargo);
		}catch(PersistenceException e){
			e.getMessage();
		}
	}
	
}
