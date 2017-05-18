package br.com.maisvida.enums;

/**
 * 
 * @author leonardo
 *
 */
public enum EstadoEnum {
	DF("Distrito Federal", "DF");

	private String descricao;
	
	private String sigla;
	
	EstadoEnum(String descricao, String sigla){
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getSigla() {
		return sigla;
	}
}
