package br.gov.fatec.moduloprofessor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.fatec.moduloprofessor.repository.ProjetoRepository;

@Service("projetoService")
public class ProjetoServiceImpl implements ProjetoService{

	
	@Autowired
	private ProjetoRepository projetoRepo;
	
	@Override
	public void excluirProjeto(String ProjTitulo) {
		projetoRepo.deleteById(projetoRepo.findByTitulo(ProjTitulo).getId());
	}

}
