package softur.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import softur.entities.Usuario;
import softur.repository.UsuarioDAO;

@SessionScoped
@ManagedBean
public class SessaoUsuarioMb {
	private Usuario usuarioLogado;
	private Usuario usuarioLogin;

	@PostConstruct
	public void init() {
		usuarioLogin = new Usuario();
	}

	public String getNomeUsuario() {
		return usuarioLogado.getNome();
	}

	public boolean isLogado() {
		return usuarioLogado != null;
	}

	public String login() {
		if (fazerLogin()) {
			return "/restrito/admin?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário ou senha não confere."));
		return "";
	}

	private boolean fazerLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarUsuarioPorNome(usuarioLogin.getNome());
		if (usuario == null)
			return false;
		if (!usuario.getSenha().equals(usuarioLogin.getSenha()))
			return false;
		if (!usuario.getNome().equalsIgnoreCase(usuarioLogin.getNome()))
			return false;
		usuarioLogado = usuario;
		return true;
	}

	public String logout() {
		usuarioLogado = null;
		return "/publico/index?faces-redirect=true";
	}

	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
}