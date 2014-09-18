package softur.main.funcionario;

import java.util.Calendar;

import softur.dao.FuncionarioDAO;
import softur.entities.Funcionario;

public class SalvandoFuncionario {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Fulano da Silva");
		
		funcionario.setCargo(null);
		
		funcionario.setCpf("05894987898");
		
		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.set(2010, 8, 21);
		funcionario.setDataEntrada(dataEntrada);
		
		Calendar dataSaida = Calendar.getInstance();
		dataEntrada.set(2013, 9, 11);
		funcionario.setDataSaida(dataSaida);
		
		funcionario.setEmail("fulano@gmail.com");
		
		funcionario.setEndereco(null);
		
		funcionario.setTelefone("22282828");
		
		funcionario.setSalario(2000d);

		FuncionarioDAO dao = new FuncionarioDAO();
		dao.iniciarTransacao();
		dao.salvarFuncionario(funcionario);
		dao.confirmarTransacao();
		dao.fecharTransacao();
	}
}
