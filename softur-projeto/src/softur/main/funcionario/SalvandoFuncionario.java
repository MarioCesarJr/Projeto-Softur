package softur.main.funcionario;

import java.util.Calendar;

import softur.dao.CargoDAO;
import softur.dao.FuncionarioDAO;
import softur.entities.Cargo;
import softur.entities.Endereco;
import softur.entities.Funcionario;

public class SalvandoFuncionario {

	public static void main(String[] args) {

		Endereco endereco = new Endereco("SC", "Florianopolis", "88786098", "Rua Motta da Silva", "21", "Brasil", "");
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Ciclano da Silva");

		Cargo cargo = new Cargo("Motorista");
		CargoDAO cDao = new CargoDAO();
		
		funcionario.setCargo(cargo);
		
		funcionario.setCpf("05894987898");
		
		funcionario.setEndereco(endereco);
		
		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.set(2010, 8, 21);
		funcionario.setDataEntrada(dataEntrada);
		
		Calendar dataSaida = Calendar.getInstance();
		dataEntrada.set(2013, 9, 11);
		funcionario.setDataSaida(dataSaida);
		
		funcionario.setEmail("ciclano@gmail.com");
		
		funcionario.setTelefone("22282828");
		
		funcionario.setSalario(2000d);
		
		cDao.iniciarTransacao();
		cDao.salvarCargo(cargo);
		cDao.confirmarTransacao();

		FuncionarioDAO dao = new FuncionarioDAO();
		dao.iniciarTransacao();
		dao.salvarFuncionario(funcionario);
		dao.confirmarTransacao();
		
		dao.fecharTransacao();
	}
}
