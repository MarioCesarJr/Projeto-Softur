package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.persistence.PersistenceException;

import softur.entities.Cliente;
import softur.repository.Clientes;
import softur.service.GestaoClientes;
import softur.util.FacesUtil;

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
	    
	    try{
	    
	    	gestaoClientes.excluir(this.clienteSelecionado);
	        this.init();
	    
	    }catch(PersistenceException e){
	    	FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Este cliente está em uma viagem  !");
	    }     
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
