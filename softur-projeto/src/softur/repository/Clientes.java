package softur.repository;

import java.util.List;

import softur.entities.Cliente;


public interface Clientes {
	
	public void salvar(Cliente Cliente);
	public void deletar(Cliente Cliente);
	public void atualizar(Cliente Cliente);
	public Cliente buscarId(Long codigo);
	public List<Cliente> listarTodos();
	public Cliente comDadosIguais(Cliente cliente);

}
