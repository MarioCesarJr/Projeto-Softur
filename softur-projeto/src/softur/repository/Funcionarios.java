package softur.repository;

import java.util.List;

import softur.entities.Funcionario;

/**
 ******************************************************************************
 *  DEFINE A REGRA DE NEGOCIO COM O BANCO DE DADOS IMPLEMENTANDO ESSES METODOS
 ******************************************************************************
 */

public interface Funcionarios {

	public void salvar(Funcionario funcionario);
	public void deletar(Funcionario funcionario);
	public void atualizar(Funcionario funcionario);
	public Funcionario buscarId(Long codigo);
	public List<Funcionario> listarTodos();
}
