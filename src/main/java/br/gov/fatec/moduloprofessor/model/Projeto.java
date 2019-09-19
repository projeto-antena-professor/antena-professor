package br.gov.fatec.moduloprofessor.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Projeto
{
	@Id
	String Id;
	String titulo;
	String fase;
	String chave;
	
	String descricao_breve;
	String  link_externo1;
	String link_externo2;
	String descricao_completa;
	String descricao_tecnologias;
	Object status;
	Object reuniao;
	List<String> entregas;
	String responsavel_cadi;
	String responsavel_empresario;
	List<String> alunos;
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public Object getStatus() {
		return status;
	}
	public void setStatus(Object status) {
		this.status = status;
	}
	public Object getReuniao() {
		return reuniao;
	}
	public void setReuniao(Object reuniao) {
		this.reuniao = reuniao;
	}
	public List<String> getEntregas() {
		return entregas;
	}
	public void setEntregas(List<String> entregas) {
		this.entregas = entregas;
	}
	public List<String> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<String> alunos) {
		this.alunos = alunos;
	}
	public String getResponsavel_cadi() {
		return responsavel_cadi;
	}
	public void setResponsavel_cadi(String responsavel_cadi) {
		this.responsavel_cadi = responsavel_cadi;
	}
	public String getResponsavel_empresario() {
		return responsavel_empresario;
	}
	public void setResponsavel_empresario(String responsavel_empresario) {
		this.responsavel_empresario = responsavel_empresario;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getDescricao_breve() {
		return descricao_breve;
	}
	public void setDescricao_breve(String descricao_breve) {
		this.descricao_breve = descricao_breve;
	}
	public String getLink_externo1() {
		return link_externo1;
	}
	public void setLink_externo1(String link_externo1) {
		this.link_externo1 = link_externo1;
	}
	public String getLink_externo2() {
		return link_externo2;
	}
	public void setLink_externo2(String link_externo2) {
		this.link_externo2 = link_externo2;
	}
	public String getDescricao_completa() {
		return descricao_completa;
	}
	public void setDescricao_completa(String descricao_completa) {
		this.descricao_completa = descricao_completa;
	}
	public String getDescricao_tecnologias() {
		return descricao_tecnologias;
	}
	public void setDescricao_tecnologias(String descricao_tecnologias) {
		this.descricao_tecnologias = descricao_tecnologias;
	}
	
	
	
}
