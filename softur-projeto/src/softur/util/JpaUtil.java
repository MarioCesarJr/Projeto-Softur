package softur.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("softurPU");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void closeFactory(){
		emf.close();
	}

}
