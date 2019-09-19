package br.gov.fatec.moduloprofessor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.fatec.moduloprofessor.model.Projeto;

@Repository
public interface ProjetoRepository extends MongoRepository<Projeto, String>
{
	@Query(value="{ 'titulo' : ?0 }")
	Projeto findByTitulo(String titulo);
	
	List<Projeto> findByFase(int fase);
}
