package softur.dao;

import java.util.List;

import javax.persistence.EntityManager;

import softur.entities.Funcionario;
import softur.util.JpaUtil;

public class FuncionarioDAO {

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
		em.remove(funcionario);
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
