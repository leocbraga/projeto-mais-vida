package br.com.maisvida.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.maisvida.collection.Medico;

/**
 * 
 * @author leonardo
 *
 */
public interface MedicoRepository extends MongoRepository<Medico, String>{

}
