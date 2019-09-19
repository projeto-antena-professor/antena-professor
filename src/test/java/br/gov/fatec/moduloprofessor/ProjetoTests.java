package br.gov.fatec.moduloprofessor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.fatec.moduloprofessor.model.Projeto;
import br.gov.fatec.moduloprofessor.repository.ProfessorRepository;
import br.gov.fatec.moduloprofessor.repository.ProjetoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
public class ProjetoTests {
	
	private static final String TITULO = "TITULO DO PROJETO";
	private static final String DESCRICAO = "DESCRICAO";
	private static final int FASE = 3;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	public void setRepo(ProjetoRepository pProjetoRepository)
	{
		projetoRepository = pProjetoRepository;
	}
	
	
	@Test
	public void adicionarProfessorTest()
	{
		
		Projeto proj = new Projeto();
		//proj.setDescricao(DESCRICAO);
		//proj.setFase(FASE);
		//proj.setTitulo(TITULO);
		//projetoRepository.save(proj);
		//assertTrue(proj.getProjetId() != null);
		
		//projetoRepository.deleteById(projetoRepository.findByTitulo(TITULO).getProjetId());
		//assertTrue(projetoRepository.findByTitulo(projetoRepository.findByTitulo(TITULO).getTitulo()) == null);
	}

}
