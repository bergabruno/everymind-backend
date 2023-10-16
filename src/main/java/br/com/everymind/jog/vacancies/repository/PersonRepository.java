package br.com.everymind.jog.vacancies.repository;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<PersonDTO, String> {

    PersonDTO findByEmail(String email);
}
