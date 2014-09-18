package softur.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Cliente implements Serializable {	

		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(length = 60, nullable = false, name = "nome_Cliente")
		private String nome;

		// tratar se for estrangeiro
		private String cpf;

		@Column(length = 11, nullable = false)
		private String telefone;

		@Column(nullable = false)
		private String email;
		
		@Column(nullable = false)
		private Date dataCadastro;
				
		@OneToOne
		private Endereco endereco;

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

		public Date getDataCadastro() {
			return dataCadastro;
		}

		public void setDataCadastro(Date dataCadastro) {
			this.dataCadastro = dataCadastro;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
		
}
