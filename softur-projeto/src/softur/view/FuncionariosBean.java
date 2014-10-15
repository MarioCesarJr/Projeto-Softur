package softur.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import softur.entities.Funcionario;
import softur.service.GestaoFuncionarios;
import softur.util.FacesUtil;
import softur.util.Repositorios;

@ManagedBean
public class FuncionariosBean {

	private Repositorios repositorios = new Repositorios();
	private Funcionario funcionario = new Funcionario();
	
	public void salvar(){
		GestaoFuncionarios gestaoFuncionarios = new GestaoFuncionarios(this.repositorios.getFuncionarios());
		gestaoFuncionarios.salvar(funcionario);
		
		this.funcionario = new Funcionario();
		
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso!");
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	
}
