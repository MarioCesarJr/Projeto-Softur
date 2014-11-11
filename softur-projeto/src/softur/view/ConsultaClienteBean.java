package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Cliente;
import softur.repository.Clientes;
import softur.service.GestaoClientes;

@ManagedBean
public class ConsultaClienteBean {
	private List<Cliente> clientesList;
	private Cliente clienteIndex;

	@PostConstruct
	public void init() {

	}

	public String excluir() {
		GestaoClientes gestaoclientes = new GestaoClientes();
		gestaoclientes.excluir(this.clienteIndex);
		this.init();
		return "";
	}

	public List<Cliente> getClientes() {
		if (clientesList == null) {
			Clientes clientes = new Clientes();
			this.clientesList = clientes.listarTodos();

		}
		return clientesList;

	}

	public Cliente getClienteIndex() {
		return clienteIndex;
	}

	public void setClienteIndex(Cliente clienteIndex) {
		this.clienteIndex = clienteIndex;
	}

}
