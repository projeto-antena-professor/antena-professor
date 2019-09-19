package br.gov.fatec.moduloprofessor.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.gov.fatec.moduloprofessor.model.Professor;
import br.gov.fatec.moduloprofessor.repository.ProfessorRepository;

@Component
public class MongoUserDetailService implements UserDetailsService{

	@Autowired
	private ProfessorRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Professor professor = repository.findByEmailInstitucional(username);
	    
		if(professor == null) {
	      throw new UsernameNotFoundException("Email não encontrado.");
	    }
		
	    List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("professor"));
	    
	    return buildUserForAuthentication(professor, authorities);
	}

	private UserDetails buildUserForAuthentication(Professor prof, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(prof.getEmailInstitucional(), prof.getSenha(), authorities);
	}
}
