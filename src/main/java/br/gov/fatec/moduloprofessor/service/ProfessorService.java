package br.gov.fatec.moduloprofessor.service;

import br.gov.fatec.moduloprofessor.model.Professor;
import br.gov.fatec.moduloprofessor.model.Projeto;

public interface ProfessorService {

	public void excluirProfessor(String nome);
	
	public void incluirProfessorSemprojeto(String nome, String sobrenome, String email, String senha, String matricula);
	
	public void incluirProfessorComProjeto(String nome, String sobrenome, String email, String senha, String matricula, Projeto projeto);
}
