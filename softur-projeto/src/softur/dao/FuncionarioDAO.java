package softur.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import softur.entities.Funcionario;
import softur.util.JpaUtil;

public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public void iniciarTransacao() {
		em = JpaUtil.createEntityManager();
		em.getTransaction().begin();
	}

	public void confirmarTransacao() {
		em.getTransaction().commit();
	}

	public void fecharTransacao() {
		em.close();
	}

	public void salvarFuncionario(Funcionario funcionario) {
		em.persist(funcionario);
	}

	public void deletarFuncionario(Funcionario funcionario) {
		funcionario = buscarFuncionarioId(funcionario.getId());
		try {
			em.remove(funcionario);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}

	}

	public void atualizar(Funcionario funcionario) {
		em.merge(funcionario);
	}

	public Funcionario buscarFuncionarioId(Long codigo) {
		Funcionario funcionario = em.find(Funcionario.class, codigo);
		if (funcionario != null) {
			return funcionario;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarFuncionarios() {
		return em.createQuery("from Funcionario").getResultList();
	}

}
