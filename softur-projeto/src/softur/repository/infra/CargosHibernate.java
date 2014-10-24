package softur.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public Cargo buscarPorCodigo(Long codigo) {
		Cargo cargo = em.find(Cargo.class, codigo);
		return cargo;
	}

	@Override
	public void deletar(Cargo cargo) {
		cargo = buscarPorCodigo(cargo.getId());
		try {
			em.remove(cargo);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
		
		
	}

	@Override
	public Cargo cargoIgual(Cargo cargo) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cargo.class)
		.add(Restrictions.eq("nomeCargo", cargo.getNomeCargo()));		
		return (Cargo) criteria.uniqueResult();
	}

}
