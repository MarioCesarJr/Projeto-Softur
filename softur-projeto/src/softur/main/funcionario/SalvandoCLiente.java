package softur.main.funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import softur.entities.Cliente;
import softur.entities.Endereco;
import softur.repository.Clientes;
import softur.repository.Funcionarios;

public class SalvandoCLiente {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("softurPU");
		EntityManager em = emf.createEntityManager();
		
		Endereco endereco = new Endereco("SC", "Florianopolis", "88095580",
				"Rua Eduardo Horn", "186", "coqueiros ", "Brasil");

		Cliente cliente = new Cliente();
		cliente.setCpf("00935041958");
		cliente.setNome("Jo�o Pedro");
		cliente.setEmail("naotenhoemail@naotenhomesmo.com.br");
		cliente.setTelefone("99999999");
		cliente.setEndereco(endereco);
		Date dataCadastro = new Date();
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dataCadastro = formatarData.parse("");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setDataCadastro(dataCadastro);
		
		Clientes dao = new Clientes(em);
		
		em.getTransaction().begin();
		dao.salvar(cliente);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
