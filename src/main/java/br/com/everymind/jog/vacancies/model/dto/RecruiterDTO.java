package br.com.everymind.jog.vacancies.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "recruiter")
@Getter
@Setter
@Validated
public class RecruiterDTO {

    @Id
    private String id;
    private String email;
    private String password;
    private String passwordEncrypted;
    private String name;
    private String phoneNumber;
    private String about;
    private String city;
    private String state;
    private Integer age;
    private Integer vagasDivulgadas;
    private List<WorkExperienceDTO> workExperienceDTOS = new ArrayList<>();
    private List<VacancyDTO> vacancyDTOS = new ArrayList<>();

    public void appendWorkExperience(WorkExperienceDTO workExperienceDTO) {
        if (this.workExperienceDTOS == null)
            this.workExperienceDTOS = new ArrayList<>();

        workExperienceDTOS.add(workExperienceDTO);
    }

    public void appendVacancy(VacancyDTO vacancyDTO) {
        if (this.vacancyDTOS == null)
            this.vacancyDTOS = new ArrayList<>();

        vacancyDTOS.add(vacancyDTO);
    }
}
