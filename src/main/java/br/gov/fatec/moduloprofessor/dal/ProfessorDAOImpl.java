package br.gov.fatec.moduloprofessor.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.gov.fatec.moduloprofessor.model.Professor;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO
{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Professor> getAllProfessores() {
		return mongoTemplate.findAll(Professor.class);
	}

	@Override
	public Professor getProfessorById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, Professor.class);
	}

	@Override
	public Professor addNovoProfessor(Professor professor) {
		mongoTemplate.save(professor);
		// Now, user object will contain the ID as well
		return professor;
	}

}
