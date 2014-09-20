package softur.dao;

import javax.persistence.EntityManager;

import softur.entities.Cargo;
import softur.util.JpaUtil;

public class CargoDAO {

	private EntityManager em;

	public void iniciarTransacao() {
		em = JpaUtil.createEntityManager();
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
