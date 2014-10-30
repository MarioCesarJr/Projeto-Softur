package softur.service;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;

public class GestaoFuncionarios {

	private Funcionarios funcionarios = new Funcionarios();
	
	public void salvar(Funcionario funcionario) throws RegraNegocioException{
		if(existeNomeIgual(funcionario)){
			throw new RegraNegocioException("Já existe um nome igual a este.");
		}
		
		this.funcionarios.salvar(funcionario);
	}
	
	private boolean existeNomeIgual(Funcionario funcionario) {
		Funcionario nomeIgual = this.funcionarios.comDadosIguais(funcionario);
		return nomeIgual != null && !nomeIgual.equals(funcionario);
	}
    
	public void excluir(Funcionario funcionario){
		this.funcionarios.deletar(funcionario);
	}
}
