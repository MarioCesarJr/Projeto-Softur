package softur.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import softur.entities.Viagem;
import softur.util.JpaUtil;

public class Viagens {

	private EntityManager em;

	public Viagens() {
		this.em = JpaUtil.getEntityManager();

	}

	public void salvar(Viagem viagem) {
		em.merge(viagem);
	}

	public Viagem buscar(Long codigo) {
		Viagem viagem = em.find(Viagem.class, codigo);
		if (viagem != null) {
			return viagem;
		}
		return null;
	}

	public void excluir(Viagem viagem) {
		viagem = buscar(viagem.getId());
		try {
			em.remove(viagem);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Viagem> todos(){
		return em.createQuery("from Viagem").getResultList();
	}
}
