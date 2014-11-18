package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Cliente;
import softur.repository.Clientes;
import softur.service.GestaoClientes;

@ManagedBean
public class ConsultaClienteBean {

	private List<Cliente> clienteslist;
    private Cliente clienteSelecionado;
    
	
	@PostConstruct
	public void init(){
		
		Clientes clientes = new Clientes();
		this.clienteslist = clientes.listarTodos();
	}
	
	public String excluir(){
	    GestaoClientes gestaoClientes = new GestaoClientes();
	    gestaoClientes.excluir(this.clienteSelecionado);
	    this.init();
	    return "";
	}
	
	public List<Cliente> getClientes() {
		return clienteslist;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	

}
