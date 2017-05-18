package br.com.maisvida.dto;

import java.io.Serializable;

/**
 * 
 * @author leonardo
 *
 */
public class LoginDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String usuario;
	
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
}
