package softur.dao;

import javax.persistence.EntityManager;

import softur.entities.Cargo;
import softur.util.JpaUtil;

public class CargoDAO {

	private EntityManager em;
	
	public CargoDAO(EntityManager entityManager){
		this.em = entityManager;
	}

	public void iniciarTransacao() {
		JpaUtil.initFactory();
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
	}

	public void confirmarTransacao() {
		em.getTransaction().commit();
	}

	public void fecharTransacao() {
		em.close();
	}

	public void salvarCargo(Cargo cargo) {
		em.persist(cargo);
	}


}
