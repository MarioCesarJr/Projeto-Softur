package softur.main.funcionario;

import java.util.Calendar;

import softur.dao.CargoDAO;
import softur.dao.EnderecoDAO;
import softur.dao.FuncionarioDAO;
import softur.entities.Cargo;
import softur.entities.Endereco;
import softur.entities.Funcionario;

public class SalvandoFuncionario {

	public static void main(String[] args) {

		Cargo cargo = new Cargo("Motorista");
		
		CargoDAO daoC = new CargoDAO();
		daoC.iniciarTransacao();
		daoC.salvarCargo(cargo);
		daoC.confirmarTransacao();
		
		Endereco endereco = new Endereco("SC", "Florianopolis", "88786098", "Rua Motta da Silva", "21", "Brasil", "");
		
		EnderecoDAO daoE = new EnderecoDAO();
		daoE.iniciarTransacao();
		daoE.salvarEndereco(endereco);
		daoE.confirmarTransacao();
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Ciclano da Silva");
		
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

		FuncionarioDAO dao = new FuncionarioDAO();
		dao.iniciarTransacao();
		dao.salvarFuncionario(funcionario);
		dao.confirmarTransacao();
		
		daoC.fecharTransacao();
		daoE.fecharTransacao();
		dao.fecharTransacao();
	}
}
