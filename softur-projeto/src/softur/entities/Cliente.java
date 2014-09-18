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

import org.jboss.logging.LogMessage;
@Entity
public class Cliente implements Serializable {	

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
		
}
