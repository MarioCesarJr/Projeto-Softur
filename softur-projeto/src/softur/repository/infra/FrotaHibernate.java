package softur.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import softur.entities.Frota;
import softur.repository.Frotas;

public class FrotaHibernate implements Frotas{
private EntityManager em;
	
	public FrotaHibernate(EntityManager entityManager){
		this.em = entityManager;
	}

	@Override
	public void salvar(Frota frota) {
		em.merge(frota);
		
	}

	@Override
	public void deletar(Frota frota) {
		frota = buscarId(frota.getId());
		try {
			em.remove(frota);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
		
	}

	@Override
	public void atualizar(Frota frota) {
		em.merge(frota);
		
	}

	@Override
	public Frota buscarId(Long codigo) {
		Frota frota = em.find(Frota.class, codigo);
		if (frota != null) {
			return frota;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Frota> listarTodos() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Frota comDadosIguais(Frota frota) {
		 Session session = em.unwrap(Session.class);
		 Criteria criteria = session.createCriteria(Frota.class)
		 .add(Restrictions.eq("placa", frota.getPlaca()))
		 .add(Restrictions.eq("chassi", frota.getChassi()));
		 return (Frota) criteria.uniqueResult();
	}
	
	

}
