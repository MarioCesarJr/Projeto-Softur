package softur.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import softur.entities.Cliente;
import softur.util.JpaUtil;

public class ClienteDao implements Serializable {

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

	public void salvarCliente(Cliente cliente) {
		em.persist(cliente);
	}

	public void excluirCliente(Cliente cliente) {
		cliente = buscarClientePorId(cliente.getId());
		try {
			em.remove(cliente);
		} catch (PersistenceException e) {
			e.getMessage();
		}
	}

	public Cliente buscarClientePorId(Long id) {
		return em.find(Cliente.class, id);
	}

	public void editarCliente(Cliente cliente) {
		em.merge(cliente);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos() {
		Query query = em.createQuery("From Cliente", Cliente.class);
		return query.getResultList();
	}

}
