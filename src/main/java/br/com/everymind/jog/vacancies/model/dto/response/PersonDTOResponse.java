package br.com.everymind.jog.vacancies.model.dto.response;

import br.com.everymind.jog.vacancies.model.dto.CoursesDTO;
import br.com.everymind.jog.vacancies.model.dto.DegreeDTO;
import br.com.everymind.jog.vacancies.model.dto.SkillsDTO;
import br.com.everymind.jog.vacancies.model.dto.WorkExperienceDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDTOResponse {

    private String photo;
    private String name;
    private String email;
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
}
