package softur.service;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;

public class GestaoFuncionarios {

	private Funcionarios funcionarios = new Funcionarios();
	
	public void salvar(Funcionario funcionario) throws RegraNegocioException{
		if(existeCpfIgual(funcionario)){
			throw new RegraNegocioException("Existe Funcionario com CPF igual a este.");
		}
		
		validarCampos(funcionario);
		
		this.funcionarios.salvar(funcionario);
	}
	
	private boolean existeCpfIgual(Funcionario funcionario) {
		Funcionario cpfIgual = this.funcionarios.comCpfIgual(funcionario);
		return cpfIgual != null && !cpfIgual.equals(funcionario);
	}
    
	public void excluir(Funcionario funcionario){
		this.funcionarios.deletar(funcionario);
	}
	
	private void validarCampos(Funcionario funcionario) throws RegraNegocioException{
		if(funcionario.getNome() == null || funcionario.getNome().equals("")){
			throw new RegraNegocioException("O campo nome é obrigatório");
		
		}else if(funcionario.getCpf() == null || funcionario.getCpf().equals("")){
			throw new RegraNegocioException("O campo CPF é obrigatório");
	
		}else if(funcionario.getDataAdmissao() == null || funcionario.getDataAdmissao().equals("")){
			throw new RegraNegocioException("O campo Data de Admissão é obrigatório");
	
		}else if(funcionario.getSalario() == null || funcionario.getSalario() == 0){
			throw new RegraNegocioException("O campo salário é obrigatório");
     
		}else if(funcionario.getCargo() == null || funcionario.getCargo().equals("")){
			throw new RegraNegocioException("O campo cargo é obrigatório");
     }
	
  }	
}