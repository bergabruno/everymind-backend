package br.com.everymind.jog.vacancies.controller;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import br.com.everymind.jog.vacancies.model.dto.WorkExperienceDTO;
import br.com.everymind.jog.vacancies.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiter")
@CrossOrigin(origins = "http://localhost:5500")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<RecruiterDTO> save(@RequestBody @Validated RecruiterDTO recruiterDTO) {
        return new ResponseEntity<>(recruiterService.save(recruiterDTO), HttpStatus.OK);
    }

    @PostMapping("/{recruiterId}/append-info")
    public ResponseEntity<RecruiterDTO> appendInfo(@PathVariable String recruiterId, @RequestBody @Validated RecruiterDTO recruiterDTO) {
        return new ResponseEntity<>(recruiterService.savePersonalInfo(recruiterDTO, recruiterId), HttpStatus.OK);
    }

    @GetMapping("/{recruiterId}")
    public ResponseEntity<RecruiterDTO> getById(@PathVariable String recruiterId) {
        return new ResponseEntity<>(recruiterService.getById(recruiterId), HttpStatus.OK);
    }

    @PostMapping("/{recruiterId}/work-experience")
    public ResponseEntity<Void> appendWorkExperience(@PathVariable String recruiterId, @RequestBody WorkExperienceDTO experienceDTO) {
        recruiterService.appendWorkExperience(recruiterId, experienceDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{recruiterId}/work-experience")
    public ResponseEntity<List<WorkExperienceDTO>> getWorkExperience(@PathVariable String recruiterId) {
        return new ResponseEntity<>(recruiterService.getAllWorkExperiences(recruiterId), HttpStatus.OK);
    }

    @PostMapping("/{recruiterId}/vacancy")
    public ResponseEntity<Void> appendVacancy(@PathVariable String recruiterId, @RequestBody VacancyDTO vacancyDTO) {
        recruiterService.appendVacancy(recruiterId, vacancyDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{recruiterId}/vacancy")
    public ResponseEntity<List<VacancyDTO>> getVacancys(@PathVariable String recruiterId) {
        return new ResponseEntity<>(recruiterService.getAllVacancy(recruiterId), HttpStatus.OK);
    }

}
