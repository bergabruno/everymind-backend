package br.com.everymind.jog.vacancies.repository;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecruiterRepository  extends MongoRepository<RecruiterDTO, String> {

    RecruiterDTO findByEmail(String email);

}
