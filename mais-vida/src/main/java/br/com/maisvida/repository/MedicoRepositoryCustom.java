package br.com.maisvida.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import br.com.maisvida.collection.Medico;
import br.com.maisvida.resources.RepositoryAbstractCustom;

/**
 * 
 * @author leonardo
 *
 */
@Repository
public class MedicoRepositoryCustom extends RepositoryAbstractCustom<Medico>{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public Class<Medico> getClazz() {
		return Medico.class;
	}
}
