package br.gov.fatec.moduloprofessor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gov.fatec.moduloprofessor.model.Professor;
import br.gov.fatec.moduloprofessor.model.Projeto;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String>
{
	public Professor findByNome(String nome);
	
	public Professor findByEmailInstitucional(String emailInstitucional);
	
	public Professor findByProjeto(Projeto projeto);
}
