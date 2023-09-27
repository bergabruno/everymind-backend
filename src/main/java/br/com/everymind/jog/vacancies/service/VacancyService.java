package br.com.everymind.jog.vacancies.service;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;

import java.util.List;

public interface VacancyService {


    List<VacancyDTO> getAll();
    List<PersonDTO> getAllByVacancy(String vacancyId);

    VacancyDTO getById(String vacancyId);
}
