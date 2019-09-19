package br.gov.fatec.moduloprofessor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.gov.fatec.moduloprofessor.model.Professor;
import br.gov.fatec.moduloprofessor.repository.ProfessorRepository;

@Controller
public class ProfessorController {

	@Autowired
	ProfessorRepository repo;
	
	@RequestMapping("/todosProfessores")
    public String professores(Model model)
	{
        model.addAttribute("professores", repo.findAll());
        return "professores.html";
    }
	
	  @RequestMapping("/adicionarProfessor")
	    public String criarProfessor(@RequestParam String nome, @RequestParam String matricula, @RequestParam String email, @RequestParam String senha) {
		  
		  Professor professor = new Professor();
		  professor.setNome(nome);
		  professor.setMatricula(matricula);
		  professor.setEmailInstitucional(email);
		  professor.setSenha(senha);
		  
		  repo.save(professor);
	      return "redirect:/show/" + professor.getProfessorId();
	    }
	  
	   @RequestMapping("/show/{id}")
	    public String show(@PathVariable String id, Model model) {
	        model.addAttribute("professor", repo.findById(id).get());
	        
	        return "show.html";
	    }  
}
