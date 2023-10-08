package br.com.everymind.jog.vacancies.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "person")
@Validated
@Getter
@Setter
public class PersonDTO {

    @Id
    private String id;
    private String photo;
    private String name;
    private String email;
    private String password;
    private String passwordEncrypted;
    private String phoneNumber;
    private String about;
    private String city;
    private String state;
    private String socialVulnerability;
    private Integer age;
    private List<SkillsDTO> skillsDTOS;
    private List<CoursesDTO> coursesDTOS;
    private List<DegreeDTO> degreeDTOS;
    private List<WorkExperienceDTO> workExperienceDTOS;
    private List<String> vacancyIds;

    public void appendSkill(SkillsDTO skillsDTO) {
        if (this.skillsDTOS == null)
            this.skillsDTOS = new ArrayList<>();

        skillsDTOS.add(skillsDTO);
    }

    public void appendCourse(CoursesDTO coursesDTO) {
        if (this.coursesDTOS == null)
            this.coursesDTOS = new ArrayList<>();

        coursesDTOS.add(coursesDTO);
    }

    public void appendDegree(DegreeDTO degreeDTO) {
        if (this.degreeDTOS == null)
            this.degreeDTOS = new ArrayList<>();

        degreeDTOS.add(degreeDTO);
    }

    public void appendWorkExperience(WorkExperienceDTO workExperienceDTO) {
        if (this.workExperienceDTOS == null)
            this.workExperienceDTOS = new ArrayList<>();

        workExperienceDTOS.add(workExperienceDTO);
    }

    public void appendVacancy(VacancyDTO vacancyDTO) {
        if (this.vacancyIds == null)
            this.vacancyIds = new ArrayList<>();

        vacancyIds.add(vacancyDTO.getId());
    }
}
