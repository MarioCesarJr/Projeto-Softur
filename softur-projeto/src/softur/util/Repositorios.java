package softur.util;

import java.io.Serializable;

import javax.persistence.EntityManager;

import softur.repository.Cargos;
import softur.repository.Clientes;
import softur.repository.Frotas;
import softur.repository.Funcionarios;
import softur.repository.infra.CargosHibernate;
import softur.repository.infra.ClienteHibernate;
import softur.repository.infra.FrotaHibernate;
import softur.repository.infra.FuncionariosHibernate;

public class Repositorios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Funcionarios getFuncionarios(){
		return new FuncionariosHibernate(this.getEntityManager());
	}
	
	public Frotas getFrotas(){
		return new FrotaHibernate(this.getEntityManager());
	}
	
	public Cargos getCargos(){
		return new CargosHibernate(this.getEntityManager());
	}
	public Clientes getClientes(){
		return new ClienteHibernate(this.getEntityManager());
	}

	private EntityManager getEntityManager(){
		return (EntityManager) FacesUtil.getRequestAttribute("entityManager");
	}
}
