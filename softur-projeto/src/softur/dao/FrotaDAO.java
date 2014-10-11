package softur.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import softur.entities.Frota;
import softur.entities.Funcionario;
import softur.util.JpaUtil;

public class FrotaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

private EntityManager em;
	
	public FrotaDAO(EntityManager entityManager){
		this.em = entityManager;
	}
	
	public void iniciarTransacao() {
		JpaUtil.initFactory();
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
	}

	public void confirmarTransacao() {
		em.getTransaction().commit();
	}

	public void fecharTransacao() {
		em.close();
		JpaUtil.closeFactory();
	}
	
	public void salvarFrota(Frota frota) {
		em.persist(frota);
	}

	public void deletarFrota(Frota frota) {
		frota = buscarFrotaId(frota.getId());
		try {
			em.remove(frota);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}

	}
	
	public void atualizar(Frota frota) {
		em.merge(frota);
	}

	public Frota buscarFrotaId(Long codigo) {
		Frota frota = em.find(Frota.class, codigo);
		if (frota != null) {
			return frota;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarFuncionarios() {
		return em.createQuery("from Frota").getResultList();
	}
}
