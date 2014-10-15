package softur.service;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;

public class GestaoFuncionarios {

	private Funcionarios funcionarios;
	
	public GestaoFuncionarios(Funcionarios funcionarios){
		this.funcionarios = funcionarios;
	}
	
	public void salvar(Funcionario funcionario){
		this.funcionarios.salvar(funcionario);
	}
}
