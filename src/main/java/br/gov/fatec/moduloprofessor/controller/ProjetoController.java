package br.gov.fatec.moduloprofessor.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import br.gov.fatec.moduloprofessor.config.EmailConfig;

@Controller	
public class ProjetoController {

	@RequestMapping("/todosProjetos")
    public String projetos(Model model)
	{
		Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("professor");
	        
	    DBCollection projetos = db.getCollection("projeto");
        model.addAttribute("projetos", projetos.find());
        return "projetos.html";
    }
	
	@RequestMapping("/gerarChave")
    public String gerarChave() throws AddressException, MessagingException
	{
		EmailConfig emailConfig = new EmailConfig();
		
		emailConfig.criarSessionMail();
		emailConfig.enviarEmailComChave("cristiano.nascimento8@fatec.sp.gov.br");
		return "redirect:/index.html";
    }
}
