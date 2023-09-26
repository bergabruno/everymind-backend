package br.com.everymind.jog.vacancies.repository;

import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacancyRepository extends MongoRepository<VacancyDTO, String> {
}
