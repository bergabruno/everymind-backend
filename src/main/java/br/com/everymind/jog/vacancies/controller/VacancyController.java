package br.com.everymind.jog.vacancies.controller;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import br.com.everymind.jog.vacancies.service.RecruiterService;
import br.com.everymind.jog.vacancies.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
@CrossOrigin(origins = "http://localhost:5500")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<List<VacancyDTO>> getAll() {
        return new ResponseEntity<>(vacancyService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{vacancyId}/persons")
    public ResponseEntity<List<PersonDTO>> getPersonByVacancy(@PathVariable String vacancyId) {
        return new ResponseEntity<>(vacancyService.getAllByVacancy(vacancyId), HttpStatus.OK);
    }

    @GetMapping("/{vacancyId}")
    public ResponseEntity<VacancyDTO> getVacancyDetails(@PathVariable String vacancyId) {
        return new ResponseEntity<>(vacancyService.getById(vacancyId), HttpStatus.OK);
    }
}
