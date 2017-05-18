package br.com.maisvida.enums;

/**
 * 
 * @author leonardo
 *
 */
public enum EspecialidadeEnum {
	CARDIOLOGISTA("cardiologista");
	
	private String descricao;
	
	EspecialidadeEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
