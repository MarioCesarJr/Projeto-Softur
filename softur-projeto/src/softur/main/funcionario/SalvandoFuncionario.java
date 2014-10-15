package softur.main.funcionario;

import java.util.Calendar;

import javax.persistence.EntityManager;

import softur.entities.Cargo;
import softur.entities.Endereco;
import softur.entities.Funcionario;
import softur.repository.infra.CargoDAO;
import softur.repository.infra.FuncionariosHibernate;

public class SalvandoFuncionario {

	public static void main(String[] args) {

		EntityManager em = null;
		
		Endereco endereco = new Endereco("SC", "Florianopolis", "88786098", "Rua Motta da Silva", "21", "Brasil", "");
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Ciclano da Silva");

		Cargo cargo = new Cargo("Motorista");
		CargoDAO cDao = new CargoDAO(em);
		
		funcionario.setCargo(cargo);
		
		funcionario.setCpf("05894987898");
		
		funcionario.setEndereco(endereco);
		
		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.set(2010, 8, 21);
//		funcionario.setDataAdmissao(dataEntrada);
				
		funcionario.setEmail("ciclano@gmail.com");
		
		funcionario.setTelefone("22282828");
		
		funcionario.setSalario(2000d);
		
		FuncionariosHibernate dao = new FuncionariosHibernate(em);
	}
}
