package br.com.maisvida.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.maisvida.dto.LoginDTO;
import br.com.maisvida.dto.LoginResponseDTO;
import br.com.maisvida.service.LoginService;

/**
 * 
 * @author leonardo
 *
 */
@RestController
@RequestMapping(value = "/login")
public class LoginResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity login(@RequestBody LoginDTO loginDto){	
		
 		LoginResponseDTO response = loginService.login(loginDto.getUsuario(), loginDto.getSenha());
		
		if(response == null || response.getToken() == null){
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity(response, HttpStatus.OK);
	}
}
