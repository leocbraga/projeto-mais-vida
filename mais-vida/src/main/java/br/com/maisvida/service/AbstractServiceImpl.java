package br.com.maisvida.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.maisvida.collection.Collection;
import br.com.maisvida.resources.RepositoryAbstractCustom;

/**
 * 
 * @author leonardo
 *
 * @param <T>
 */
public abstract class AbstractServiceImpl<T extends Collection> implements AbstractService<T>{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void salvar(T t){
		getRepository().save(t);
	}
	
	@Override
	public T buscarPorId(String id){
		return getRepository().findOne(id);
	}
	
	@Override
	public List<T> buscarTodos(){
		return getRepository().findAll();
	}
	
	@Override
	public List<T> buscarPorParametros(Map<String, String> parametros){
		return getRepositoryCustom().buscarPorParametros(parametros);
	}
	
	@Override
	public void excluir(String id){
		getRepository().delete(id);
	}
	
	public abstract MongoRepository<T, String> getRepository();
	
	public RepositoryAbstractCustom<T> getRepositoryCustom(){
		throw new UnsupportedOperationException("Nenhum repository custom foi identificado na classe service");
	}

}
