package softur.service;

import softur.entities.Cliente;
import softur.repository.Clientes;

public class GestaoClientes {

	private Clientes clientes = new Clientes();
	
	public void salvar(Cliente cliente) throws RegraNegocioException{
		if(existeCpfIgual(cliente)){
			throw new RegraNegocioException("Existe Cliente com CPF igual a este.");
		}
		
		validarCampos(cliente);
		
		this.clientes.salvar(cliente);
	}
	
	private boolean existeCpfIgual(Cliente cliente) {
		Cliente cpfIgual = this.clientes.comCpfIgual(cliente);
		return cpfIgual != null && !cpfIgual.equals(cliente);
	}
    
	public void excluir(Cliente cliente){
		this.clientes.deletar(cliente);
	}
	
	private void validarCampos(Cliente cliente) throws RegraNegocioException{
		if(cliente.getNome() == null || cliente.getNome().equals("")){
			throw new RegraNegocioException("O campo nome é obrigatório");
		
		}else if(cliente.getCpf() == null || cliente.getCpf().equals("")){
			throw new RegraNegocioException("O campo CPF é obrigatório");
	
     }
	
  }	
}