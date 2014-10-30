package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;
import softur.service.GestaoFuncionarios;

@ManagedBean
public class ConsultaFuncionarioBean {

	private List<Funcionario> funcionariosList;
    private Funcionario funcionarioSelecionado;
    
	
	@PostConstruct
	public void init(){
		
		Funcionarios funcionarios = new Funcionarios();
		this.funcionariosList = funcionarios.listarTodos();
	}
	
	public String excluir(){
	    GestaoFuncionarios gestaoFuncionarios = new GestaoFuncionarios();
	    gestaoFuncionarios.excluir(this.funcionarioSelecionado);
	    this.init();
	    return "";
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionariosList;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	
	

}
