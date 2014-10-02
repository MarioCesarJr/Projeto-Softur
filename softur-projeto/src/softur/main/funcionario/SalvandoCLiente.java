package softur.main.funcionario;

import java.util.Calendar;

import softur.dao.ClienteDao;
import softur.dao.EnderecoDAO;
import softur.entities.Cliente;
import softur.entities.Endereco;

public class SalvandoCLiente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Endereco endereco = new Endereco("SC", "Florianopolis", "88095580",
				"Rua Eduardo Horn", "186", "Brasil", "");
		EnderecoDAO endDao = new EnderecoDAO();
		endDao.iniciarTransacao();
		endDao.salvarEndereco(endereco);
		endDao.confirmarTransacao();

		Cliente cliente = new Cliente();
		cliente.setCpf("00935041958");
		cliente.setNome("Jo�o Pedro");
		cliente.setEmail("naotenhoemail@naotenhomesmo.com.br");
		cliente.setTelefone("99999999");
		
		Calendar dataCad = Calendar.getInstance();
		cliente.setDataCadastro(dataCad);
		
		
		ClienteDao cDao = new ClienteDao();
		cDao.iniciarTransacao();
		cDao.salvarCliente(cliente);
		cDao.confirmarTransacao();
		cDao.fecharTransacao();

	}
}
