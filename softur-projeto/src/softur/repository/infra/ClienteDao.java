package softur.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import softur.entities.Cliente;

public class ClienteDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	public ClienteDao(EntityManager em){
		this.entityManager = em;
	}


	public void salvarCliente(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public void excluirCliente(Cliente cliente) {
		cliente = buscarClientePorId(cliente.getId());
		try {
			entityManager.remove(cliente);
		} catch (PersistenceException e) {
			e.getMessage();
		}
	}

	public Cliente buscarClientePorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	public void editarCliente(Cliente cliente) {
		entityManager.merge(cliente);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos() {
		Query query = entityManager.createQuery("From Cliente", Cliente.class);
		return query.getResultList();
	}

}
