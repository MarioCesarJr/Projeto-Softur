package softur.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, nullable = false, name = "nome_funcionario")
	private String nome;

	// tratar se for estrangeiro
	private String cpf;

	@Column(length = 11, nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "cod_cargo")
	private Cargo cargo;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Calendar dataEntrada;

	@Temporal(TemporalType.DATE)
	private Calendar dataSaida;

	@Column(nullable = false)
	private Double salario;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cod_endereco")
	private Endereco endereco;

	private String status;

	@Lob
	private String observacao;

	private String numeroCNH;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
	
	private static boolean validaCNH(String CNH) {
        CNH = desformatar(CNH);
        if (!CNH.matches("[0-9]{11}")) {
            return false;
        }
 
        if (CNH.equals("11111111111") || CNH.equals("22222222222") || CNH.equals("33333333333")
                || CNH.equals("44444444444") || CNH.equals("55555555555") || CNH.equals("66666666666")
                || CNH.equals("77777777777") || CNH.equals("88888888888") || CNH.equals("99999999999")
                || CNH.equals("00000000000")) {
            return false;
        }
 
        int[] fracao = new int[9];
        int acumulador = 0;
        int inc = 2;
        for (int i = 0; i < 9; i++) {
            fracao[i] = (Math.abs(Integer.parseInt(CNH.substring(i, 1)))) * inc;
            acumulador += fracao[i];
            inc++;
        }
 
        int resto = acumulador % 11;
        int digito1 = 0;
        if (resto > 1) {
            digito1 = 11 - resto;
        }
        acumulador = digito1 * 2;
        inc = 3;
        for (int i = 0; i < 9; i++) {
            fracao[i] = (Math.abs(Integer.parseInt(CNH.substring(i, 1)))) * inc;
            acumulador += Math.abs(fracao[i]);
            inc++;
        }
 
        resto = acumulador % 11;
        int digito2 = 0;
        if (resto > 1) {
            digito2 = 11 - resto;
        }
        if (digito1 == Math.abs(Integer.parseInt(CNH.substring(9, 1)))
                && digito2 == Math.abs(Integer.parseInt(CNH.substring(10, 1)))) {
            return true;
        }
 
        return false;
    }
	
	private static String desformatar(String valor) {
        String str = "";
        String caracter = "";
        for (int i = 0; i < valor.length(); i++) {
            caracter = valor.substring(i, 1);
            if (ehNumero(caracter)) {
                str += caracter;
            }
        }
        return str;
    }
 
    private static boolean ehNumero(String caracter) {
        for (int i = 0; i <= 9; i++) {
            if (caracter.equals("" + i)) {
                return true;
            }
        }
 
        return false;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
