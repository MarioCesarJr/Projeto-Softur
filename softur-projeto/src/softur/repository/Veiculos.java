package softur.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import softur.entities.Veiculo;

public class Veiculos{
private EntityManager em;
	
	public Veiculos(EntityManager entityManager){
		this.em = entityManager;
	}

	
	public void salvar(Veiculo frota) {
		em.merge(frota);
		
	}

	
	public void deletar(Veiculo frota) {
		frota = buscarId(frota.getId());
		try {
			em.remove(frota);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
		
	}

	
	public void atualizar(Veiculo frota) {
		em.merge(frota);
		
	}

	public Veiculo buscarId(Long codigo) {
		Veiculo frota = em.find(Veiculo.class, codigo);
		if (frota != null) {
			return frota;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listarTodos() {
		return em.createQuery("from Cliente").getResultList();
	}

	public Veiculo comDadosIguais(Veiculo frota) {
		 Session session = em.unwrap(Session.class);
		 Criteria criteria = session.createCriteria(Veiculo.class)
		 .add(Restrictions.eq("placa", frota.getPlaca()))
		 .add(Restrictions.eq("chassi", frota.getChassi()));
		 return (Veiculo) criteria.uniqueResult();
	}
	
	

}
