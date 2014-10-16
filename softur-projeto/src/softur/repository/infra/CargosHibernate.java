package softur.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;

import softur.entities.Cargo;
import softur.repository.Cargos;

public class CargosHibernate implements Cargos {

	private EntityManager em;
	
	public CargosHibernate(EntityManager EntityManager){
		this.em = EntityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> listarTodos() {
		return em.createQuery("From Cargo").getResultList();
	}

	@Override
	public void salvar(Cargo cargo) {
		em.persist(cargo);
		
	}

}
