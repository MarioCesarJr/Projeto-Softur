package softur.conexao;

import javax.persistence.Persistence;

public class TestConexao {

	public static void main(String[] args) {   
		
		Persistence.createEntityManagerFactory("softurPU");
		
		System.out.println("Conexão feita com sucesso !");
	}
}
