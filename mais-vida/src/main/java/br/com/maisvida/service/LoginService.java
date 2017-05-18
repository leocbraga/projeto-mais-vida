package br.com.maisvida.service;

import java.io.Serializable;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.maisvida.dto.LoginResponseDTO;
import br.com.maisvida.exception.MaisVidaException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * TODO: Esta classe é apenas um Mock simulando um autenticação client/credentials por token
 * @author leonardo
 *
 */
@Component
public class LoginService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static Key KEY = MacProvider.generateKey(); 
	
	//TODO Mock
	public LoginResponseDTO login(String usuario, String senha){
		if(isUsuarioValido(usuario, senha)){
			return new LoginResponseDTO(usuario, getTokenPorUsuarioSenha(usuario, senha));
		}
		
		return null;
	}
	
	//TODO Mock
	public boolean isTokenValido(String token){
		if(token == null){
			return Boolean.FALSE;
		}
		
		String subject = Jwts.parser()
				.setSigningKey(KEY)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
		
		String[] informacoesUsuario = subject.split(":");
		
		if(informacoesUsuario.length != 2){
			throw new MaisVidaException("Token Inválido");
		}
		
		return isUsuarioValido(informacoesUsuario[0], informacoesUsuario[1]);
	}
	
	//TODO Mock
	private boolean isUsuarioValido(String usuario, String senha){
		Map<String, String> usuarios = getUsuarios();
		
		String senhaCorreta = usuarios.get(usuario);
		
		return senhaCorreta != null && senhaCorreta.equals(senha);
	}
	
	//TODO Mock
	private Map<String, String> getUsuarios(){
		Map<String, String> usuarios = new HashMap<>();
		
		usuarios.put("admin", "admin");
		usuarios.put("leoanrdo", "123456");
		
		return usuarios;
	}
	
	//TODO Mock
	private String getTokenPorUsuarioSenha(String usuario, String senha){
		String jwt = Jwts.builder()
				.setSubject(usuario + ":" + senha)
				.signWith(SignatureAlgorithm.HS256, KEY).compact();
		
		return jwt;
	}

}
