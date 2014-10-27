package softur.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import softur.entities.Cliente;
import softur.repository.Clientes;

public class ClienteHibernate implements Clientes {
	
private EntityManager em;
	
	public ClienteHibernate(EntityManager entityManager){
		this.em = entityManager;
	}

	@Override
	public void salvar(Cliente cliente) {
		em.merge(cliente);
		
	}

	@Override
	public void deletar(Cliente cliente) {
		cliente = buscarId(cliente.getId());
		try {
			em.remove(cliente);
			em.flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		em.merge(cliente);
		
	}

	@Override
	public Cliente buscarId(Long codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		if (cliente != null) {
			return cliente;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarTodos() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Cliente comDadosIguais(Cliente cliente) {
		 Session session = em.unwrap(Session.class);
		 Criteria criteria = session.createCriteria(Cliente.class)
		 .add(Restrictions.eq("nome", cliente.getNome()))
		 .add(Restrictions.eq("cpf", cliente.getCpf()));
		 return (Cliente) criteria.uniqueResult();
	}
	

}
