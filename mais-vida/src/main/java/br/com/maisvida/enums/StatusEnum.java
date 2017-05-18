package br.com.maisvida.enums;

/**
 * 
 * @author leonardo
 *
 */
public enum StatusEnum {
	OCUPADO("Ocupado");
	
	private String descricao;
	
	StatusEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
