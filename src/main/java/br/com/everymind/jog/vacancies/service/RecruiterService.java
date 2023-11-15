package br.com.everymind.jog.vacancies.service;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import br.com.everymind.jog.vacancies.model.dto.WorkExperienceDTO;

import java.util.List;

public interface RecruiterService {

    RecruiterDTO save(RecruiterDTO recruiterDTO);

    RecruiterDTO savePersonalInfo(RecruiterDTO recruiterDTO, String id);

    RecruiterDTO getById(String id);

    void appendWorkExperience(String recruiterId, WorkExperienceDTO workExperienceDTO);

    List<WorkExperienceDTO> getAllWorkExperiences(String recruiterId);

    void appendVacancy(String recruiterId, VacancyDTO vacancyDTO);

    List<VacancyDTO> getAllVacancy(String recruiterId);

    RecruiterDTO login(RecruiterDTO personDTO);

}

