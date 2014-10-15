package softur.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;

/**
 ************************************************************** 
 * IMPLEMENTACAO DOS METODOS DE TRANSACAO COM O BANCO DE DADOS
 **************************************************************
 */

public class FuncionariosHibernate implements Funcionarios {

	private EntityManager em;
	
	public FuncionariosHibernate(EntityManager entityManager){
		this.em = entityManager;
	}

	@Override
	public void salvar(Funcionario funcionario) {
		em.persist(funcionario);
		
	}

	@Override
	public void deletar(Funcionario funcionario) {
		funcionario = buscarId(funcionario.getId());
		try {
			em.remove(funcionario);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
		
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		em.merge(funcionario);
		
	}

	@Override
	public Funcionario buscarId(Long codigo) {
		Funcionario funcionario = em.find(Funcionario.class, codigo);
		if (funcionario != null) {
			return funcionario;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listarTodos() {
		return em.createQuery("from Funcionario").getResultList();
	}
	
	
}
