package softur.view;

import javax.faces.bean.ManagedBean;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import softur.util.EmailUtil;

@ManagedBean
public class ContatoMB {

	private String nome;
	private String email;
	private String senha;
	private String assunto;
	private Integer area;
	private String mensagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String enviar() {
		String mensagemText = "Nome: " + nome + "\nEmail: " + email
				+ "\nSenha: " + senha + "\nÁrea: " + area + "\nMensagem: "
				+ mensagem + "\nAssunto: " + assunto;

		try {
			EmailUtil.enviarEmail(email, "Contato via site.", mensagemText);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return "";
	}

}