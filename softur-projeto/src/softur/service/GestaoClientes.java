package softur.service;

import softur.entities.Cliente;
import softur.repository.Clientes;


public class GestaoClientes {

	private Clientes clienteRep = new Clientes();

	public void salvar(Cliente clienteEnt) throws RegraNegocioException {
		if (existeNomeIgual(clienteEnt)) {
			throw new RegraNegocioException("Já existe um nome igual a este.");
		}
		this.clienteRep.salvar(clienteEnt);
	}

	private boolean existeNomeIgual(Cliente clienteEnt) {
		Cliente nomeIgual = this.clienteRep.comDadosIguais(clienteEnt);
		return nomeIgual != null && !nomeIgual.equals(clienteEnt);
	}

	public void excluir(Cliente clienteEnt) {
		this.clienteRep.deletar(clienteEnt);
	}

}