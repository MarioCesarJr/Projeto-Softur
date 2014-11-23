package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Viagem;
import softur.repository.Viagens;
import softur.service.GestaoViagem;

@ManagedBean
public class ConsultaViagemBean {

	private List<Viagem> viagensList;
	private Viagem viagemSelecionada;

	@PostConstruct
	public void init() {
		Viagens viagens = new Viagens();
		this.viagensList = viagens.todos();
	}
	
	public String excluir(){
		GestaoViagem gestaoViagem = new GestaoViagem();
		gestaoViagem.excluir(viagemSelecionada);
		init();
		return "";
	}

	public List<Viagem> getViagensList() {
		return viagensList;
	}

	public Viagem getViagemSelecionada() {
		return viagemSelecionada;
	}

	public void setViagemSelecionada(Viagem viagemSelecionada) {
		this.viagemSelecionada = viagemSelecionada;
	}
}
