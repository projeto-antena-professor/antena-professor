package br.gov.fatec.moduloprofessor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Professor
{

    @Id
    String id;
    String nome;
    String sobrenome;
    String matricula;
    String emailInstitucional;
    String senha;
    Projeto projeto;
    
    public Projeto getProjeto(){
		return projeto;
	}
    
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	

    public String getProfessorId() {
        return id;
    }

    public void setProfessorId(String professorId) {
        this.id = professorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
