package br.com.maisvida.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.maisvida.collection.Medico;
import br.com.maisvida.exception.MaisVidaException;
import br.com.maisvida.repository.MedicoRepository;
import br.com.maisvida.repository.MedicoRepositoryCustom;
import br.com.maisvida.util.ValidacaoUtil;

/**
 * 
 * @author leonardo
 *
 */
@Component
public class MedicoService extends AbstractServiceImpl<Medico> {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private MedicoRepositoryCustom medicoRepositoryCustom;
	
	@Override
	public void salvar(Medico medico){
		Map<String, String> validacoes = isMedicoValido(medico);
		
		if(!validacoes.isEmpty()){
			throw new MaisVidaException("Campos inválidos: " + validacoes.toString());
		}
		
		super.salvar(medico);
	}
	
	/**
	 * Método responsável por ativar o médico
	 * @param id
	 */
	public void ativarMedico(String id){
		if(isMedicoAtivo(id)){
			throw new MaisVidaException("O médico já está ativo");
		}
		
		Medico medico = medicoRepository.findOne(id);
		
		medico.setAtivo(Boolean.TRUE);
		
		medicoRepository.save(medico);
	}
	
	/**
	 * Método responsável por inativar o médico
	 * @param id
	 */
	public void inativarMedico(String id){
		if(!isMedicoAtivo(id)){
			throw new MaisVidaException("O médico já está inativo");
		}
		
		Medico medico = medicoRepository.findOne(id);
		
		medico.setAtivo(Boolean.FALSE);
		
		medicoRepository.save(medico);
	}
	
	/**
	 * Método responsável por verificar se um médico está ativo
	 * @param id
	 * @return
	 */
	public boolean isMedicoAtivo(String id){
		Medico medico = medicoRepository.findOne(id);
		
		if(medico == null){
			throw new MaisVidaException("Nenhum médico encontrado com o id: " + id);
		}
		
		return medico.isAtivo();
	}
	
	/**
	 * Método responsável por verificar se um médico está inativo
	 * @param id
	 * @return
	 */
	public boolean isMedicoInativo(String id){
		return !isMedicoAtivo(id);
	}
	
	/**
	 * Método responsável por validar um médico
	 * @param medico
	 * @return
	 */
	private Map<String, String> isMedicoValido(Medico medico){
		if(medico != null){
			Map<String, String> validacoes = new HashMap<>();
			
			if(!ValidacaoUtil.isEmailValido(medico.getEmail())){
				validacoes.put("Email Inválido", medico.getEmail());
			}
			
			if(ValidacaoUtil.isCampoVazio(medico.getNome())){
				validacoes.put("Nome não informado", medico.getNome());
			}
			
			return validacoes;
		}else{
			throw new MaisVidaException("O objeto informado está nulo");
		}
	}
	
	@Override
	public MedicoRepository getRepository() {
		return medicoRepository;
	}
	
	@Override
	public MedicoRepositoryCustom getRepositoryCustom(){
		return medicoRepositoryCustom;
	}
}
