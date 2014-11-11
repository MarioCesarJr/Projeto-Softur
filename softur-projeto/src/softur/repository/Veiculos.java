package softur.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import softur.entities.Veiculo;
import softur.util.JpaUtil;

public class Veiculos {
	
	private EntityManager em;

	public Veiculos(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	public Veiculos(){
		this.em = JpaUtil.getEntityManager();
	}

	public void salvar(Veiculo veiculo) {
		em.merge(veiculo);

	}

	public void deletar(Veiculo veiculo) {
		veiculo = buscarId(veiculo.getId());
		try {
			em.remove(veiculo);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}

	}

	public Veiculo buscarId(Long codigo) {
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		if (veiculo != null) {
			return veiculo;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listarTodos() {
		return em.createQuery("from Veiculo").getResultList();
	}

}
