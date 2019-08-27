package br.gov.fatec.moduloprofessor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.moduloprofessor.dal.ProfessorDAO;
import br.gov.fatec.moduloprofessor.dal.ProfessorRepository;
import br.gov.fatec.moduloprofessor.model.Professor;

@RestController
@RequestMapping(value = "/")
public class ProfessorController
{
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final ProfessorRepository professorRepository;

    private final ProfessorDAO professorDAO;

    public ProfessorController(ProfessorRepository professorRepository, ProfessorDAO professorDAO)
    {
        this.professorRepository = professorRepository;
        this.professorDAO = professorDAO;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Professor addNewUsers(@RequestBody Professor professor)
    {
        LOG.info("Saving professor.");
        return professorRepository.save(professor);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Professor> getAllUsers()
    {
        return professorRepository.findAll();
    }

    @RequestMapping(value = "/{ProfessorId}", method = RequestMethod.GET)
    public Professor getUser(@PathVariable String professorId)
    {
        return professorRepository.findOne(professorId);
    }
}