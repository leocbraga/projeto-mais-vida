package br.com.maisvida.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.maisvida.collection.Medico;
import br.com.maisvida.exception.MaisVidaException;
import br.com.maisvida.service.MedicoService;

/**
 * 
 * @author leonardo
 *
 */
@RestController
@RequestMapping(value = "/api/medicos")
public class MedicoResource extends AbstractResource<Medico>{
	
	@Autowired
	private MedicoService medicoService;

	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/{id}/ativar", method = RequestMethod.PUT, produces = {"application/json"})
	public ResponseEntity ativar(@PathVariable(name = "id") String id){
		try{
			getService().ativarMedico(id);
			
			return new ResponseEntity(HttpStatus.OK);
		}catch(MaisVidaException e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{id}/desativar", method = RequestMethod.PUT, produces = {"application/json"})
	public ResponseEntity desativar(@PathVariable(name = "id") String id){
		try{
			getService().inativarMedico(id);
			
			return new ResponseEntity(HttpStatus.OK);
		}catch(MaisVidaException e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public MedicoService getService() {
		return medicoService;
	}
}
