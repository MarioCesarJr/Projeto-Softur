package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.persistence.PersistenceException;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;
import softur.service.GestaoFuncionarios;
import softur.util.FacesUtil;

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
	    
	    try{
	    
	    	gestaoFuncionarios.excluir(this.funcionarioSelecionado);
	        this.init();
	    
	    }catch(PersistenceException e){
	    	FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Este Funcionario está em uma viagem  !");
	    }
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
