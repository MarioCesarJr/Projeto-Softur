package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import softur.entities.Cliente;
import softur.entities.Funcionario;
import softur.entities.Veiculo;
import softur.entities.Viagem;
import softur.repository.Clientes;
import softur.repository.Funcionarios;
import softur.repository.Veiculos;
import softur.service.GestaoViagem;
import softur.util.FacesUtil;

@ManagedBean
public class CadastroViagemBean {

	private Viagem viagem;
	private List<Veiculo> veiculosList;
	private List<Funcionario> funcionariosList;
	private List<Cliente> clientesList; 
	
	@PostConstruct
	public void init(){
		Veiculos veiculos = new Veiculos();
		this.veiculosList = veiculos.listarTodos();
		
		Funcionarios funcionarios = new Funcionarios();
		this.funcionariosList = funcionarios.listarTodos();
		
		Clientes clientes = new Clientes();
		this.clientesList = clientes.listarTodos();
		
		this.viagem = new Viagem();
		this.viagem.setCliente(new Cliente());
	}

	public String salvar() {
		GestaoViagem gestaoViagem = new GestaoViagem();
		gestaoViagem.salvar(viagem);
		
		this.viagem = new Viagem();
		
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Viagem Salva com sucesso !");

		return "";
	}

	public Viagem getViagem() {
		return viagem;
	}
	
	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
		if(this.viagem == null){
			this.viagem = new Viagem();
			this.viagem.setCliente(new Cliente());
		}
	}
	
	public List<Veiculo> getVeiculosList() {
		return veiculosList;
	}
	
	public List<Funcionario> getFuncionariosList() {
		return funcionariosList;
	}
	
	public List<Cliente> getClientesList() {
		return clientesList;
	}
}
