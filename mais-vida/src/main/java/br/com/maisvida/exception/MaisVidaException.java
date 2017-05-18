package br.com.maisvida.exception;

/**
 * 
 * @author leonardo
 *
 */
public class MaisVidaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MaisVidaException(String mensagem, Throwable throwable){
		super(mensagem, throwable);
	}
	
	public MaisVidaException(String mensagem){
		super(mensagem);
	}

}
