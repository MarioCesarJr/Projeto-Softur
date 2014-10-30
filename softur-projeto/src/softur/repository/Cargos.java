package softur.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import softur.entities.Cargo;
import softur.util.JpaUtil;

public class Cargos {

	private EntityManager em;
	
	public Cargos(EntityManager entityManager){
		this.em = entityManager; 
	}
	
	public Cargos(){
		this.em = JpaUtil.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> listarTodos() {
		return em.createQuery("From Cargo").getResultList();
	}

	public void salvar(Cargo cargo) {
		em.persist(cargo);
		
	}

	public Cargo buscarPorCodigo(Long codigo) {
		Cargo cargo = em.find(Cargo.class, codigo);
		return cargo;
	}

	public void deletar(Cargo cargo) {
		cargo = buscarPorCodigo(cargo.getId());
		try {
			em.remove(cargo);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
		
		
	}

	public Cargo cargoIgual(Cargo cargo) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cargo.class)
		.add(Restrictions.eq("nomeCargo", cargo.getNomeCargo()));		
		return (Cargo) criteria.uniqueResult();
	}

}
