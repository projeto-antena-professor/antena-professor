package br.gov.fatec.moduloprofessor.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.client.MongoCollection;

@Component
public class MongoUserDetailService implements UserDetailsService{

	Mongo mongo = new Mongo("localhost", 27017);
	DB db = mongo.getDB("professor");
	DBCollection collectionProfessor = db.getCollection("professor");
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("professor.email", email);
		
		DBObject professor = collectionProfessor.findOne(whereQuery);
		Object usuario = professor.get( "professor" );
		System.out.println(usuario);
		
		DBCursor cursor = collectionProfessor.find(whereQuery);
		if( cursor.hasNext()) {
			System.out.println(cursor);
		}
		if(usuario == null) {
	      throw new UsernameNotFoundException("Email não encontrado.");
	    }
		
	    List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("professor"));
	    
	    return buildUserForAuthentication(usuario, authorities);
	}

	private UserDetails buildUserForAuthentication(Object c,  List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User("Nome", "@Senha1",  authorities);
	}
}
