package softur.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;
import softur.util.Repositorios;

@ManagedBean
public class ConsultaFuncionarioBean {

	private Repositorios repositorios = new Repositorios();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	@PostConstruct
	public void init(){
		
		Funcionarios funcionarios = this.repositorios.getFuncionarios();
		this.funcionarios = funcionarios.listarTodos();
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
