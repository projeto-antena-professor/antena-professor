package br.gov.fatec.moduloprofessor.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gov.fatec.moduloprofessor.model.Professor;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {
}
