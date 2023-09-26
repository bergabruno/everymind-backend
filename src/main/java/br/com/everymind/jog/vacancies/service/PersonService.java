package br.com.everymind.jog.vacancies.service;

import br.com.everymind.jog.vacancies.model.dto.*;

import java.util.List;

public interface PersonService {

    PersonDTO save(PersonDTO personDTO);

    PersonDTO getById(String id);

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

    List<PersonDTO> findByParameters(Integer age, String city, String socialVulnerability);
}
