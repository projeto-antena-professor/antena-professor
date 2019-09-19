package br.gov.fatec.moduloprofessor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.fatec.moduloprofessor.model.Professor;
import br.gov.fatec.moduloprofessor.model.Projeto;
import br.gov.fatec.moduloprofessor.repository.ProfessorRepository;
import br.gov.fatec.moduloprofessor.repository.ProjetoRepository;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService
{

	@Autowired
	private ProfessorRepository professorRepo;
	
	@Autowired
	private ProjetoRepository projetoRepo;
	
	@Override
	public void excluirProfessor(String nome)
	{
		professorRepo.delete(professorRepo.findByNome(nome));
	}

	@Override
	public void incluirProfessorSemprojeto(String nome, String sobrenome, String emailInstitucional, String senha, String matricula)
	{
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setSobrenome(sobrenome);
		professor.setEmailInstitucional(emailInstitucional);
		professor.setSenha(senha);
		professor.setMatricula(matricula);

		professorRepo.save(professor);
	}

	@Override
	public void incluirProfessorComProjeto(String nome, String sobrenome, String emailInstitucional, String senha, String matricula,
			Projeto projeto)
	{
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setSobrenome(sobrenome);
		professor.setEmailInstitucional(emailInstitucional);
		professor.setSenha(senha);
		professor.setMatricula(matricula);
		
		Projeto proj = new Projeto();
		
		//proj.setDescricao("Descrição");
		//proj.setFase(4);
		//proj.setTitulo("Titulo");
		
		projetoRepo.save(proj);
		
		professor.setProjeto(projetoRepo.findByTitulo("Titulo"));
		professorRepo.save(professor);
	}
}
