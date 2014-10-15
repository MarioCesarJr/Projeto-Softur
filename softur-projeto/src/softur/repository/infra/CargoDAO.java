package softur.repository.infra;

import javax.persistence.EntityManager;

import softur.entities.Cargo;

public class CargoDAO {

	private EntityManager em;
	
	public CargoDAO(EntityManager entityManager){
		this.em = entityManager;
	}

	public void salvarCargo(Cargo cargo) {
		em.persist(cargo);
	}


}
