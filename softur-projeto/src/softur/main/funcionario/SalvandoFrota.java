package softur.main.funcionario;

import javax.persistence.EntityManager;

import softur.entities.Frota;
import softur.repository.infra.FrotaDAO;
import softur.repository.infra.FuncionariosHibernate;

public class SalvandoFrota {

	public static void main(String[] args) {

		EntityManager em = null;

		Frota frota = new Frota();

		frota.setMarca("Volvo");
		frota.setModelo("B215LH");
		frota.setBanheiro(true);
		frota.setPlaca("BZO-1258");
		frota.setChassi("9BWZZZ377VT004251");
		frota.setPoltronas(30);

		FrotaDAO dao = new FrotaDAO(em);
	}

}
