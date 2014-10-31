package softur.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Veiculo veiculo;
	private Funcionario funcionario;
	private String tipoServico;
	private String fornecedor;
	private String situacao;
	private Date dataPlanejamento;
	private Date inicioServico;
	private Date terminoServico;
	private String numeroDocumento;
	private BigDecimal valor;
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataPlanejamento() {
		return dataPlanejamento;
	}

	public void setDataPlanejamento(Date dataPlanejamento) {
		this.dataPlanejamento = dataPlanejamento;
	}

	public Date getInicioServico() {
		return inicioServico;
	}

	public void setInicioServico(Date inicioServico) {
		this.inicioServico = inicioServico;
	}

	public Date getTerminoServico() {
		return terminoServico;
	}

	public void setTerminoServico(Date terminoServico) {
		this.terminoServico = terminoServico;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
