package sistema.Modelo;

public class UsuarioLogado {
	private static UsuarioLogado usuarioLogado;
	private Usuario informacoesUsuario;
	
	private UsuarioLogado() {}
	
	public static UsuarioLogado retornarUsuario() {
		if (usuarioLogado == null) {
			usuarioLogado = new UsuarioLogado();
		}
		return usuarioLogado;
	}
	
	public void setInformacoesUsuario(Usuario informacoes) {
		informacoesUsuario = informacoes;
	}
	public Usuario getInformacoesUsuario() {
		return informacoesUsuario;
	}

}
