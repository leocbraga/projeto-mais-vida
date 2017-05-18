package br.com.maisvida.resources;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.maisvida.enums.EstadoEnum;

/**
 * 
 * @author leonardo
 *
 */
@RestController
@RequestMapping(value = "/api/ufs")
public class UFResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity buscarTodos(){			
		return new ResponseEntity(EstadoEnum.values(), HttpStatus.OK);
	}
}
