package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import softur.entities.Cargo;
import softur.entities.Cliente;
import softur.entities.Endereco;
import softur.entities.Funcionario;
import softur.service.GestaoClientes;
import softur.service.GestaoFuncionarios;
import softur.service.RegraNegocioException;
import softur.util.FacesUtil;

public class ClientesBean {

	private Cliente clienteEnt;

	@PostConstruct
	public void init() {

		clienteEnt = new Cliente();
		clienteEnt.setEndereco(new Endereco());

	}

	public String salvar() {
		GestaoClientes gestaoClientes = new GestaoClientes();

		try {

			gestaoClientes.salvar(clienteEnt);

			clienteEnt = new Cliente();

			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO,
					"Cliente cadastrado!");

		} catch (RegraNegocioException e) {

			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
					e.getMessage());
		}

		return "";
	}

	public Cliente getCliente() {
		return clienteEnt;
	}

	// Quando salvar não retornar nulo
	public void setCliente(Cliente cliente) throws CloneNotSupportedException {
		clienteEnt = cliente;
		if (clienteEnt == null) {
			clienteEnt = new Cliente();
			clienteEnt.setEndereco(new Endereco());
		} else {
			// evitar erro quando for atualizar um dado ja existente devido a
			// restricao de nomes iguais
			clienteEnt = (Cliente) clienteEnt.clone();
		}
	}

}
