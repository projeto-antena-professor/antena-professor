package br.gov.fatec.moduloprofessor.dal;

import java.util.List;

import br.gov.fatec.moduloprofessor.model.Professor;

public interface ProfessorDAO
{

	List<Professor> getAllProfessores();

	Professor getProfessorById(String professorId);

	Professor addNovoProfessor(Professor professor);
}