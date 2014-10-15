package softur.util;

import java.io.Serializable;

import javax.persistence.EntityManager;

import softur.repository.Funcionarios;
import softur.repository.infra.FuncionariosHibernate;

public class Repositorios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Funcionarios getFuncionarios(){
		return new FuncionariosHibernate(this.getEntityManager());
	}

	private EntityManager getEntityManager(){
		return (EntityManager) FacesUtil.getRequestAttribute("entityManager");
	}
}