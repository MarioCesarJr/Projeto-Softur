package softur.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import softur.entities.Usuario;
import softur.util.JpaUtil;

public class UsuarioDAO {
	private EntityManager entityManager;

	public UsuarioDAO() {
		entityManager = JpaUtil.getEntityManager();
	}

	public Usuario buscarUsuarioPorNome(String nome) {
		Query query = entityManager.createQuery(
				"From Usuario u Where u.nome = :nome", Usuario.class);
		query.setParameter("nome", nome);
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}
}