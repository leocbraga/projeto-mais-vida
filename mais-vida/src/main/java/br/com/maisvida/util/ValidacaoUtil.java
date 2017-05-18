package br.com.maisvida.util;

import java.io.Serializable;

/**
 * 
 * @author leonardo
 *
 */
public abstract class ValidacaoUtil  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//TODO: Melhorar validação
	public static boolean isEmailValido(String email){
		if(email != null){
			return email.contains("@")
					&& email.contains(".");
		}
		return Boolean.TRUE;
	}
	
	public static boolean isCampoVazio(String campo){
		return campo == null || campo.isEmpty();
	}

}
