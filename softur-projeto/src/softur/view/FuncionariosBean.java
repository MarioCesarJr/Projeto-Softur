package softur.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import softur.entities.Cargo;
import softur.entities.Endereco;
import softur.entities.Funcionario;
import softur.repository.Cargos;
import softur.service.GestaoFuncionarios;
import softur.service.RegraNegocioException;
import softur.util.FacesUtil;
import softur.util.Repositorios;

@ManagedBean
public class FuncionariosBean {

	private Repositorios repositorios = new Repositorios();
	private List<Cargo> cargos = new ArrayList<Cargo>();
	private Funcionario funcionario;
	
	@PostConstruct
	public void init(){
		Cargos cargos = this.repositorios.getCargos();
		this.cargos = cargos.listarTodos();
		
		funcionario = new Funcionario();
		funcionario.setEndereco(new Endereco());
		funcionario.setCargo(new Cargo());
	}
	
	public String salvar(){
		GestaoFuncionarios gestaoFuncionarios = new GestaoFuncionarios(this.repositorios.getFuncionarios());
		
		try {
			
			gestaoFuncionarios.salvar(funcionario);
			
			this.funcionario = new Funcionario();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso!");
		
		} catch (RegraNegocioException e) {
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,e.getMessage());
		}
		
		
	   return "";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}
	
	
}
