package softur.main.funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import softur.entities.Cargo;
import softur.entities.Endereco;
import softur.entities.Funcionario;
import softur.repository.Funcionarios;

public class SalvandoFuncionario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("softurPU");
		EntityManager em = emf.createEntityManager();
		
		Endereco endereco = new Endereco("SC", "Florianopolis", "88786098", "Rua Motta da Silva", "21", "estreito", "Brasil");
		
		Cargo cargo = new Cargo();
		cargo.setId(1L);
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCargo(cargo);
		
		funcionario.setNome("Ciclano da Silva");
		
		funcionario.setCpf("05894987898");
		
		funcionario.setEndereco(endereco);
		
        Date data = new Date();
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			data = formatarData.parse("11/12/2012");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		funcionario.setDataAdmissao(data);
				
		funcionario.setEmail("ciclano@gmail.com");
		
		funcionario.setTelefone("22282828");
		
		funcionario.setSalario(2000d);
		
		Funcionarios dao = new Funcionarios(em);
		
		em.getTransaction().begin();
		dao.salvar(funcionario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
