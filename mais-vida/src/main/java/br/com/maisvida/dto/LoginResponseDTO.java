package br.com.maisvida.dto;

import java.io.Serializable;

/**
 * 
 * @author leonardo
 *
 */
public class LoginResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	//JWT
	private String token;
	
	public LoginResponseDTO(String usuario, String token){
		setUsuario(usuario);
		setToken(token);
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}
