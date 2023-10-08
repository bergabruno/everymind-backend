package br.com.everymind.jog.vacancies.service.impl;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import br.com.everymind.jog.vacancies.repository.PersonRepository;
import br.com.everymind.jog.vacancies.repository.VacancyRepository;
import br.com.everymind.jog.vacancies.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<VacancyDTO> getAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public List<PersonDTO> getAllByVacancy(String vacancyId) {
        VacancyDTO vacancyDTO = vacancyRepository.findById(vacancyId).orElseThrow();

        if (vacancyDTO.getPersonIds() == null){
            return new ArrayList<>();
        }

        return personRepository.findAllById(vacancyDTO.getPersonIds());
    }

    @Override
    public VacancyDTO getById(String vacancyId) {
        return vacancyRepository.findById(vacancyId).orElseThrow();
    }
}
