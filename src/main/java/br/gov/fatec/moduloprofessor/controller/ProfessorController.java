package br.gov.fatec.moduloprofessor.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import br.gov.fatec.moduloprofessor.config.EmailConfig;

@Controller
public class ProfessorController {

    Mongo mongo = new Mongo("localhost", 27017);
    DB db = mongo.getDB("professor");
    DBCollection professores = db.getCollection("professor");
    
    EmailConfig emailConfig = new EmailConfig();
    
    @RequestMapping("/todosProfessores")
    public String professores(Model model)
    {
        model.addAttribute("professores", professores.find());
        return "professores.html";
    }
    	
      @RequestMapping(value = "/adicionarProfessor", method = RequestMethod.POST)
        public String criarProfessor(@RequestParam String nome, @RequestParam String matricula, 
        		@RequestParam String email, @RequestParam String senha)
      {
    	  try{
    		  if (validaEmail(email))
    		  {
    			  String prof = "{'professor':{'nome':'" +nome+ "','matricula':'"+ matricula +"','email':'"+ email +"','senha':'"+ senha+"'}}";
    			  
    			  DBCollection professores = db.getCollection("professor");
    			  DBObject professor = (DBObject) JSON.parse(prof);
    			  professores.insert(professor);
    			  emailConfig.criarSessionMail();
    			  emailConfig.enviarEmail(email, nome);
    			  return "redirect:/index.html";
    		  }
    	  }
    	  catch(Exception e)
    	  {
    		  e.getMessage();
    	  }
		return "Alguma coisa por enquanto";
    	  
        }
      
       private static boolean validaEmail(String email) {
    	   boolean isEmailIdValid = false;
    	    if (email != null && email.length() > 0) {
    	        String expression = "^[\\w\\.-]+@fatec.sp.gov.br";
    	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
    	        Matcher matcher = pattern.matcher(email);
    	        if (matcher.matches()) {
    	            isEmailIdValid = true;
    	        }
    	    }
    	    return isEmailIdValid;
	}



	@RequestMapping("/mostrar/{id}")
        public String show(@PathVariable String id, Model model) {
    	String query = "'_id' :" + id +" ";
        model.addAttribute("professor", professores.findOne(query));
        System.out.println(professores.findOne(query));
        return "showProfessor.html";
        }  
}
