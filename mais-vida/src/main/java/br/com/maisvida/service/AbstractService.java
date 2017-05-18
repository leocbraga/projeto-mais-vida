package br.com.maisvida.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.maisvida.collection.Collection;

/**
 * 
 * @author leonardo
 *
 * @param <T>
 */
public interface AbstractService<T extends Collection> extends Serializable{
	
	public void salvar(T t);
	
	public T buscarPorId(String id);
	
	public List<T> buscarTodos();
	
	public List<T> buscarPorParametros(Map<String, String> parametros);
	
	public void excluir(String id);
}
