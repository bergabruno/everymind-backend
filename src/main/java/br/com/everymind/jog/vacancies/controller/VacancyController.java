package br.com.everymind.jog.vacancies.controller;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import br.com.everymind.jog.vacancies.service.RecruiterService;
import br.com.everymind.jog.vacancies.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<List<VacancyDTO>> getAll() {
        return new ResponseEntity<>(vacancyService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{vacancyId}")
    public ResponseEntity<List<PersonDTO>> getPersonByVacancy(@PathVariable String vacancyId) {
        return new ResponseEntity<>(vacancyService.getAllByVacancy(vacancyId), HttpStatus.OK);
    }
}
