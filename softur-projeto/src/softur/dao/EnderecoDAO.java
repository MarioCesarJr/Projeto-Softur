package softur.dao;

import javax.persistence.EntityManager;

import softur.entities.Endereco;
import softur.util.JpaUtil;

public class EnderecoDAO {

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

	public void salvarEndereco(Endereco endereco) {
		em.persist(endereco);
	}

}
