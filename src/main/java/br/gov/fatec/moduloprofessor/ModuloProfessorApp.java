package br.gov.fatec.moduloprofessor;

import java.io.File;
import java.net.URI;
import java.net.URL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

@SpringBootApplication
public class ModuloProfessorApp {

	public static void main(String[] args) {
		SpringApplication.run(ModuloProfessorApp.class, args);
	}
    //@Bean
    //public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}
		@Bean
		public CommandLineRunner inserirProjetoFromJson() {
			return (args) -> {
				// save a couple of customers
				try {
					
					Mongo mongo = new Mongo("localhost", 27017);
					DB db = mongo.getDB("professor");
					
					// get a single collection
					DBCollection collectionProjeto = db.getCollection("projeto");
					collectionProjeto.drop();
					DBObject projeto = (DBObject) JSON.parse("{'empresario':{'nome':'aa','email':'bbb','empresa':'embraboing','cpf':'vcc','senha':'ddd','ativo':false},'projeto':{'_id':'6ads68we','titulo':'a','descricao_breve':'a','link_externo_1':'','link_externo_2':'','descricao_completa':'a','descricao_tecnologias':'','fase':4,'reuniao':{'data':'','horario':'','local':'','datas_possiveis':[{'data':'02/03/2020','hora':'13:50'}]},'status':{'negado':true,'motivo':'sou um merda'},'entregas':[{'aluno_responsavel':'responsavel@email.com','alunos':['outros@email.com'],'link_repositorio':'http://repo.com.br','link_cloud':'http://cloud.com','comentario':'sla'}],'responsavel_cadi':'suamae@hotmail.com','responsavel_professor':['seupai@yahoo.com'],'responsavel_empresario':'empresario@email','alunos':['email@alunos.com.br']}}");
					collectionProjeto.insert(projeto);
					
					DBCollection collectionProfessor = db.getCollection("professor");
					collectionProfessor.drop();
					
					//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
					//String senhaAdmin = encoder.encode("@Senha1");
					
					DBObject professor = (DBObject) JSON.parse("{'professor':{'nome':'admin','matricula':'123456-7','email':'admin@fatec.gov.br','senha':'@Senha1'}}");
					collectionProfessor.insert(professor);
					
					System.out.println(collectionProfessor.find()); 
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};	
	}	
}