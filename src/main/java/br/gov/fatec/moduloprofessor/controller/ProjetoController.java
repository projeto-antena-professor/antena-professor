package br.gov.fatec.moduloprofessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.gov.fatec.moduloprofessor.repository.ProjetoRepository;

@Controller	
public class ProjetoController {

	@Autowired
	ProjetoRepository repo;
	
	@RequestMapping("/todosProjetos")
    public String projetos(Model model)
	{
        model.addAttribute("projetos", repo.findAll());
        return "projetos.html";
    }
}
