package softur.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import softur.entities.Endereco;
import softur.entities.Funcionario;
import softur.service.GestaoFuncionarios;
import softur.util.FacesUtil;
import softur.util.Repositorios;

@ManagedBean
public class FuncionariosBean {

	private Repositorios repositorios = new Repositorios();
	private Funcionario funcionario;
	
	@PostConstruct
	public void init(){
		funcionario = new Funcionario();
		funcionario.setEndereco(new Endereco());
		
	}
	
	public String salvar(){
		GestaoFuncionarios gestaoFuncionarios = new GestaoFuncionarios(this.repositorios.getFuncionarios());
		gestaoFuncionarios.salvar(funcionario);
		
		this.funcionario = new Funcionario();
		
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso!");
	   return "";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	
}
