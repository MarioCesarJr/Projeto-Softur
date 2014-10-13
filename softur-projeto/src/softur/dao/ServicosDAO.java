package softur.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import softur.entities.Funcionario;
import softur.entities.Servicos;
import softur.util.JpaUtil;

public class ServicosDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public ServicosDAO(EntityManager entityManager){
		this.em = entityManager;
	}

	//Abrir transacao Servicos
	public void iniciarTransacao() {
		JpaUtil.initFactory();
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
	}

	//Confirma transacao Servicos
	public void confirmarTransacao() {
		em.getTransaction().commit();
	}

	public void fecharTransacao() {
		em.close();
		JpaUtil.closeFactory();
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
