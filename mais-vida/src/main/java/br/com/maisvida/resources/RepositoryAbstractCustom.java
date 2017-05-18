package br.com.maisvida.resources;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.maisvida.collection.Collection;

/**
 * 
 * @author leonardo
 *
 */
public abstract class RepositoryAbstractCustom<T extends Collection> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public List<T> buscarPorParametros(Map<String, String> parametros){
		Query query = new Query();
		
		for(Entry<String, String> entry : parametros.entrySet()){
			query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
		}
		
		return getMongoTemplate().find(query, getClazz());
	}
	
	public abstract MongoTemplate getMongoTemplate();
	
	public abstract Class<T> getClazz();
}
