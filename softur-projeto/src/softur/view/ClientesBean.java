package softur.view;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


import softur.entities.Endereco;
import softur.entities.Cliente;

import softur.service.GestaoClientes;
import softur.service.RegraNegocioException;
import softur.util.FacesUtil;

@ManagedBean
public class ClientesBean {


	private Cliente cliente = new Cliente();
	
	@PostConstruct
	public void init(){
		
		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
	}
	
	public String salvar(){
		GestaoClientes gestaoClientes = new GestaoClientes();
		
		try {
			
			gestaoClientes.salvar(cliente);
			
			this.cliente = new Cliente();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso!");
		
		} catch (RegraNegocioException e) {
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,e.getMessage());
		}
		
		
	   return "";
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	// Quando salvar não retornar nulo
	public void setCliente(Cliente cliente) throws CloneNotSupportedException {
		this.cliente = cliente;
		if(this.cliente == null){
			this.cliente = new Cliente();
			this.cliente.setEndereco(new Endereco());
		}else{
			// evitar erro quando for atualizar um dado ja existente devido a restricao de nomes iguais
			this.cliente = (Cliente)cliente.clone();
		}
	}

	
	
	
	
}
