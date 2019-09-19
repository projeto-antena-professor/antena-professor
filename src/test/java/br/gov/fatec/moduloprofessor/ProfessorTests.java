package br.gov.fatec.moduloprofessor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.fatec.moduloprofessor.model.Professor;
import br.gov.fatec.moduloprofessor.model.Projeto;
import br.gov.fatec.moduloprofessor.repository.ProfessorRepository;
import br.gov.fatec.moduloprofessor.repository.ProjetoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
public class ProfessorTests
{

	private static final String NOME = "Usuário Test";
	private static final String SOBRENOME = "Sobrenome";
	private static final String SENHA = "Test";
	private static final String EMIAL_INSTITUCIONAL = "@fatec.sp.gov.br";
	private static final String MATRICULA = "123456-7";
	
	private static final String TITULO = "TITULO DO PROJETO";
	private static final String DESCRICAO = "DESCRICAO";
	private static final int FASE = 3;
	
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	/**
	 * @param usuarioRepo the usuarioRepo to set
	 */
	public void setRepo(ProfessorRepository pProfessorRepository)
	{
		this.professorRepository = pProfessorRepository;
	}
	
	@Test
	public void adicionarProfessorTest()
	{
		Professor prof = new Professor();
		prof.setNome(NOME);
		prof.setSobrenome(SOBRENOME);
		prof.setEmailInstitucional(EMIAL_INSTITUCIONAL);
		prof.setMatricula(MATRICULA);
		prof.setSenha(SENHA);

		
		
	}
}
