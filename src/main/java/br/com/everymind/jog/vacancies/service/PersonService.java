package br.com.everymind.jog.vacancies.service;

import br.com.everymind.jog.vacancies.model.dto.*;

import java.util.List;

public interface PersonService {

    PersonDTO save(PersonDTO personDTO);
    PersonDTO savePersonalInfo(PersonDTO personDTO, String id);

    PersonDTO getById(String id);

    PersonDTO login(PersonDTO personDTO);

    List<PersonDTO> getAll();

    void appendSkill(String personId, SkillsDTO skillsDTO);

    void appendCourse(String personId, CoursesDTO coursesDTO);

    void appendDegree(String personId, DegreeDTO degreeDTO);

    void appendWorkExperience(String personId, WorkExperienceDTO workExperienceDTO);

    List<SkillsDTO> getAllSkills(String personId);

    List<CoursesDTO> getAllCourses(String personId);

    List<DegreeDTO> getAllDegrees(String personId);

    List<WorkExperienceDTO> getAllWorkExperiences(String personId);

    void appendSocialVulnerability(String personId, String socialVulnerability);

    List<PersonDTO> findByParameters(String searchText);


    void appendVacancy(String personId, String vacancyId);

    List<VacancyDTO> getAllVacancys(String personId);
}
