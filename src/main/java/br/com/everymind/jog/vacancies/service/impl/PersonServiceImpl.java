package br.com.everymind.jog.vacancies.service.impl;

import br.com.everymind.jog.vacancies.model.dto.*;
import br.com.everymind.jog.vacancies.repository.PersonRepository;

import br.com.everymind.jog.vacancies.repository.VacancyRepository;
import br.com.everymind.jog.vacancies.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private VacancyRepository vacancyRepository;


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        return personRepository.save(personDTO);
    }

    @Override
    public PersonDTO getById(String id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado ninguem com este ID: " + id));
    }

    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void appendSkill(String personId, SkillsDTO skillsDTO) {
        PersonDTO personDTO = getById(personId);
        personDTO.appendSkill(skillsDTO);
        save(personDTO);
    }

    @Override
    public void appendCourse(String personId, CoursesDTO coursesDTO) {
        PersonDTO personDTO = getById(personId);
        personDTO.appendCourse(coursesDTO);
        save(personDTO);
    }

    @Override
    public void appendDegree(String personId, DegreeDTO degreeDTO) {
        PersonDTO personDTO = getById(personId);
        personDTO.appendDegree(degreeDTO);
        save(personDTO);
    }

    @Override
    public void appendWorkExperience(String personId, WorkExperienceDTO workExperienceDTO) {
        PersonDTO personDTO = getById(personId);
        personDTO.appendWorkExperience(workExperienceDTO);
        save(personDTO);
    }

    @Override
    public List<SkillsDTO> getAllSkills(String personId) {
        return getById(personId).getSkillsDTOS();
    }

    @Override
    public List<CoursesDTO> getAllCourses(String personId) {
        return getById(personId).getCoursesDTOS();
    }

    @Override
    public List<DegreeDTO> getAllDegrees(String personId) {
        return getById(personId).getDegreeDTOS();
    }

    @Override
    public List<WorkExperienceDTO> getAllWorkExperiences(String personId) {
        return getById(personId).getWorkExperienceDTOS();
    }

    @Override
    public void appendSocialVulnerability(String personId, String socialVulnerability) {
        PersonDTO personDTO = getById(personId);
        personDTO.setSocialVulnerability(socialVulnerability);
        save(personDTO);
    }

    @Override
    public List<PersonDTO> findByParameters(Integer age, String city, String socialVulnerability) {
        Query query = new Query();

        if (age != null) {
            query.addCriteria(Criteria.where("age").is(age));
        }

        if (city != null) {
            query.addCriteria(Criteria.where("city").is(city));
        }

        if (socialVulnerability != null) {
            query.addCriteria(Criteria.where("socialVulnerability").is(socialVulnerability));
        }

        return mongoTemplate.find(query, PersonDTO.class);
    }

    @Override
    public void appendVacancy(String personId, String vacancyId) {
        VacancyDTO vacancyDTO = vacancyRepository.findById(vacancyId).orElseThrow(() -> new RuntimeException("Não foi encontrado ninguem com este ID: " + vacancyId));;

        PersonDTO personDTO = getById(personId);

        personDTO.appendVacancy(vacancyDTO);
        vacancyDTO.appendPerson(personDTO);

        save(personDTO);
        vacancyRepository.save(vacancyDTO);
    }

    @Override
    public List<VacancyDTO> getAllVacancys(String personId) {
        PersonDTO personDTO = getById(personId);

        return vacancyRepository.findAllById(personDTO.getVacancyIds());
    }

}
