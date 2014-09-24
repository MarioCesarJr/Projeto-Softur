package softur.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import softur.entities.Cliente;
import softur.util.JpaUtil;

public class ClienteDao {
	private EntityManager em;
	

	public ClienteDao(EntityManager entityManager){
		this.em = entityManager;
	}
	
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
	
	public void salvarCliente (Cliente cliente){
		em.persist(cliente);
	}
	
	public void excluirClientePorId(Long l){
		Cliente cliente = em.getReference(Cliente.class, l);
	}
	
	public Cliente buscarClientePorId(Long id){
		return em.find(Cliente.class, id);
	}
	
	public void editarCliente(Cliente cliente){
		em.merge(cliente);
	}	
	
	public List<Cliente> listarTodos(){
		Query query = em.createQuery("From cliente", Cliente.class);
		
		return query.getResultList();
	}
	
	
	
	
}
