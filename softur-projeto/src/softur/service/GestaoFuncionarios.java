package softur.service;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;

public class GestaoFuncionarios {

	private Funcionarios funcionarios = new Funcionarios();
	
	public void salvar(Funcionario funcionario) throws RegraNegocioException{
		if(existeCpfIgual(funcionario)){
			throw new RegraNegocioException("Existe Funcionario com CPF igual a este.");
		}
		
		this.funcionarios.salvar(funcionario);
	}
	
	private boolean existeCpfIgual(Funcionario funcionario) {
		Funcionario cpfIgual = this.funcionarios.comCpfIgual(funcionario);
		return cpfIgual != null && !cpfIgual.equals(funcionario);
	}
    
	public void excluir(Funcionario funcionario){
		this.funcionarios.deletar(funcionario);
	}
}
