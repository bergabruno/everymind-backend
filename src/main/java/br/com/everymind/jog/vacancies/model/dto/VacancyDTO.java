package br.com.everymind.jog.vacancies.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vacancy")
@Getter
@Setter
public class VacancyDTO {
    @Id
    private String id;
    private String role;
    private String locality;
    private String description;
    private String requirements;
    private String steps;
}
