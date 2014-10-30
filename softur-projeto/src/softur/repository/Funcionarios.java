package softur.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import softur.entities.Funcionario;
import softur.util.JpaUtil;

public class Funcionarios {

	private EntityManager em;
	
	public Funcionarios(){
		this.em = JpaUtil.getEntityManager();
	}

	public void salvar(Funcionario funcionario) {
		em.merge(funcionario);
		
	}

	public void deletar(Funcionario funcionario) {
		funcionario = buscarId(funcionario.getId());
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

	public Funcionario buscarId(Long codigo) {
		Funcionario funcionario = em.find(Funcionario.class, codigo);
		if (funcionario != null) {
			return funcionario;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarTodos() {
		return em.createQuery("from Funcionario").getResultList();
	}

	public Funcionario comDadosIguais(Funcionario funcionario) {
		 Session session = em.unwrap(Session.class);
		 Criteria criteria = session.createCriteria(Funcionario.class)
		 .add(Restrictions.eq("nome", funcionario.getNome()))
		 .add(Restrictions.eq("cpf", funcionario.getCpf()));
		 return (Funcionario) criteria.uniqueResult();
	}
	
	
}
