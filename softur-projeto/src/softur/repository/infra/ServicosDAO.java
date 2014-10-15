package softur.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import softur.entities.Servicos;

public class ServicosDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public ServicosDAO(EntityManager entityManager){
		this.em = entityManager;
	}


	//Salva Servicos
	public void salvarServicos(Servicos servicos) {
		em.persist(servicos);
	}

	//Deleta Servicos
	public void deletarServicos(Servicos servicos) {
		servicos = buscarServicosId(servicos.getId());
		try {
			em.remove(servicos);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}

	}

	//Atualiza Servicos
	public void atualizar(Servicos servicos) {
		em.merge(servicos);
	}

	//Busca Servicos
	public Servicos buscarServicosId(Long codigo) {
		Servicos servicos = em.find(Servicos.class, codigo);
		if (servicos != null) {
			return servicos;
		}

		return null;
	}

	//lista Servicos
	@SuppressWarnings("unchecked")
	public List<Servicos> listarServicos() {
		return em.createQuery("from Servicos").getResultList();
	}
	
	


}
