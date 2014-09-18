package softur.conexao;

import javax.persistence.Persistence;

public class TestConexao {

	public static void main(String[] args) {   
		
		// GERA AS TABELAS
		Persistence.createEntityManagerFactory("softurPU");
		
		System.out.println("===========================");
		System.out.println("<<<<<<< Connected ! >>>>>>>");
		System.out.println("===========================");
	}
}
