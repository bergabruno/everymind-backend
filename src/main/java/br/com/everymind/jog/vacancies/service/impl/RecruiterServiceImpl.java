package br.com.everymind.jog.vacancies.service.impl;

import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import br.com.everymind.jog.vacancies.model.dto.WorkExperienceDTO;
import br.com.everymind.jog.vacancies.repository.RecruiterRepository;
import br.com.everymind.jog.vacancies.repository.VacancyRepository;
import br.com.everymind.jog.vacancies.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private VacancyRepository vacancyRepository;


    @Override
    public RecruiterDTO save(RecruiterDTO recruiterDTO) {
        return recruiterRepository.save(recruiterDTO);
    }

    @Override
    public RecruiterDTO getById(String id) {
        return recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado ninguem com este ID: " + id));
    }

    @Override
    public void appendWorkExperience(String recruiterId, WorkExperienceDTO workExperienceDTO) {
        RecruiterDTO recruiterDTO = getById(recruiterId);
        recruiterDTO.appendWorkExperience(workExperienceDTO);
        save(recruiterDTO);
    }

    @Override
    public List<WorkExperienceDTO> getAllWorkExperiences(String recruiterId) {
        return getById(recruiterId).getWorkExperienceDTOS();
    }

    @Override
    public void appendVacancy(String recruiterId, VacancyDTO vacancyDTO) {
        vacancyDTO.setRecruiterId(recruiterId);
        vacancyRepository.save(vacancyDTO);

        RecruiterDTO recruiterDTO = getById(recruiterId);
        recruiterDTO.appendVacancy(vacancyDTO);
        save(recruiterDTO);
    }

    @Override
    public List<VacancyDTO> getAllVacancy(String recruiterId) {
        return getById(recruiterId).getVacancyDTOS();
    }
}
