package softur.view;

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

@ManagedBean
public class FuncionariosBean {

	private List<Cargo> cargosList;
	private Funcionario funcionario;
	
	@PostConstruct
	public void init(){
		Cargos cargosHibernate = new Cargos();
		this.cargosList = cargosHibernate.listarTodos();
		
		funcionario = new Funcionario();
		funcionario.setEndereco(new Endereco());
	}
	
	public String salvar(){
		GestaoFuncionarios gestaoFuncionarios = new GestaoFuncionarios();
		
		try {
			
			gestaoFuncionarios.salvar(funcionario);
			
			this.funcionario = new Funcionario();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Funcionario salvo com sucesso!");
		
		} catch (RegraNegocioException e) {
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,e.getMessage());
		}
		
		
	   return "";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	// Quando salvar não retornar nulo
	public void setFuncionario(Funcionario funcionario) throws CloneNotSupportedException {
		this.funcionario = funcionario;
		if(this.funcionario == null){
			this.funcionario = new Funcionario();
			this.funcionario.setEndereco(new Endereco());
		}else{
			// evitar erro quando for atualizar um dado ja existente devido a restricao de nomes iguais
			this.funcionario = (Funcionario)funcionario.clone();
		}
	}

	public List<Cargo> getCargos() {
		return cargosList;
	}
	
	
}
