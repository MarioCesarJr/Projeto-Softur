package softur.main.funcionario;

import javax.persistence.EntityManager;

import softur.entities.Veiculo;

public class SalvandoFrota {

	public static void main(String[] args) {

		EntityManager em = null;

		Veiculo frota = new Veiculo();

		frota.setMarca("Volvo");
		frota.setModelo("B215LH");
		frota.setBanheiro("Sim");
		frota.setPlaca("BZO-1258");
		frota.setChassi("9BWZZZ377VT004251");
		frota.setPoltronas("23");

		
	}

}
