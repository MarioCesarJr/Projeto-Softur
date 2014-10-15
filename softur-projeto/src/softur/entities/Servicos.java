package softur.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Servicos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( nullable = false)
	private String descricao;
	
	@Column( nullable = false)
	private Double preco;
	
	@Column( nullable = false)
	private Frota veiculo;
	
	@Column( nullable = false)
	private Cidade cidadeOrigem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Frota getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Frota veiculo) {
		this.veiculo = veiculo;
	}

	public Cidade getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(Cidade cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	@Override
	public String toString() {
		return "Servicos [id=" + id + ", descricao=" + descricao + ", preco="
				+ preco + ", veiculo=" + veiculo + ", cidadeOrigem="
				+ cidadeOrigem + "]";
	}

	
	
	
	
	
}
