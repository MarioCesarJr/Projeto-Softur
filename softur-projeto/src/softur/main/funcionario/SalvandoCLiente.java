package softur.main.funcionario;

import java.util.Calendar;

import javax.persistence.EntityManager;

import softur.entities.Cliente;
import softur.entities.Endereco;
import softur.repository.infra.ClienteDao;

public class SalvandoCLiente {

	public static void main(String[] args) {
		EntityManager em = null;
		
		Endereco endereco = new Endereco("SC", "Florianopolis", "88095580",
				"Rua Eduardo Horn", "186", "coqueiros ", "Brasil");

		Cliente cliente = new Cliente();
		cliente.setCpf("00935041958");
		cliente.setNome("Jo�o Pedro");
		cliente.setEmail("naotenhoemail@naotenhomesmo.com.br");
		cliente.setTelefone("99999999");
		cliente.setEndereco(endereco);
		
		Calendar dataCad = Calendar.getInstance();
		cliente.setDataCadastro(dataCad);
		
		

	}
}
