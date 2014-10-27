package softur.service;

import softur.entities.Cliente;
import softur.entities.Funcionario;
import softur.repository.Clientes;
import softur.repository.Funcionarios;

public class GestaoClientes {
	private Clientes clientes;
	
	public GestaoClientes(Clientes clientes){
		this.clientes = clientes;
	}
	
	public void salvar(Cliente cliente) throws RegraNegocioException{
		if(existeNomeIgual(cliente)){
			throw new RegraNegocioException("Já existe um nome igual a este.");
		}
		
		this.clientes.salvar(cliente);
	}
	
	private boolean existeNomeIgual(Cliente cliente) {
		Cliente nomeIgual = this.clientes.comDadosIguais(cliente);
		return nomeIgual != null && !nomeIgual.equals(cliente);
	}
    
	public void excluir(Cliente cliente){
		this.clientes.deletar(cliente);
	}

}
