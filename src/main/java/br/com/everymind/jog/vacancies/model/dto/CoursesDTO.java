package br.com.everymind.jog.vacancies.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursesDTO {

    private String institution;
    private String course;
    private String urlValidateCredential;
    private String credentialCode;
}
