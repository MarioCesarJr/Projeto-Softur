package softur.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;
import softur.service.GestaoFuncionarios;
import softur.util.Repositorios;

@ManagedBean
public class ConsultaFuncionarioBean {

	private Repositorios repositorios = new Repositorios();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private Funcionario funcionarioSelecionado;
    
	
	@PostConstruct
	public void init(){
		
		Funcionarios funcionarios = this.repositorios.getFuncionarios();
		this.funcionarios = funcionarios.listarTodos();
	}
	
	public String excluir(){
	    GestaoFuncionarios gestaoFuncionarios = new GestaoFuncionarios(this.repositorios.getFuncionarios());
	    gestaoFuncionarios.excluir(this.funcionarioSelecionado);
	    this.init();
	    return "";
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	
	

}
