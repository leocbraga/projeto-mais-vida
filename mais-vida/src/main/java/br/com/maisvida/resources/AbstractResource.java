package br.com.maisvida.resources;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.maisvida.collection.Collection;
import br.com.maisvida.exception.MaisVidaException;
import br.com.maisvida.service.AbstractService;

/**
 * 
 * @author leonardo
 *
 * @param <T>
 */
@RestController
public abstract class AbstractResource<T extends Collection> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity salvar(@RequestBody T t){
		try{
			getService().salvar(t);
			
			return new ResponseEntity(HttpStatus.OK);
		}catch(MaisVidaException e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity buscarPorId(@PathVariable(name = "id") String id){
		try{
			return ResponseEntity.ok(getService().buscarPorId(id));
		}catch(MaisVidaException e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity buscarPorParametros(@RequestParam Map<String,String> parametros){
		try{
			return ResponseEntity.ok(getService().buscarPorParametros(parametros));
		}catch(MaisVidaException e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity excluir(@RequestParam("id") String id){
		try{
			getService().excluir(id);
			return new ResponseEntity(HttpStatus.OK);
		}catch(MaisVidaException e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity buscarTodos(){
		try{
			List<T> items = getService().buscarTodos();
			
			return ResponseEntity.ok(items);
		}catch(MaisVidaException e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public abstract AbstractService<T> getService();
}
