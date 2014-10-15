package softur.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory;

	public static void initFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("softurPU");
		}
	}

	public static void closeFactory() {
		entityManagerFactory.close();
	}

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
