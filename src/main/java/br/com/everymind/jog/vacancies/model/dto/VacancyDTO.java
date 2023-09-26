package br.com.everymind.jog.vacancies.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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
    private String recruiterId;
    private List<String> personIds;

    public void appendPerson(PersonDTO personDTO) {
        if (this.personIds == null)
            this.personIds = new ArrayList<>();

        personIds.add(personDTO.getId());
    }
}
