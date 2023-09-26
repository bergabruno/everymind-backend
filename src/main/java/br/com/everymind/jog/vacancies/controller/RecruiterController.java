package br.com.everymind.jog.vacancies.controller;

import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
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
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;


    @PostMapping
    public ResponseEntity<RecruiterDTO> save(@RequestBody @Validated RecruiterDTO recruiterDTO) {
        return new ResponseEntity<>(recruiterService.save(recruiterDTO), HttpStatus.OK);
    }

    @GetMapping("/{recruiterId}")
    public ResponseEntity<RecruiterDTO> getById(@PathVariable String recruiterId) {
        return new ResponseEntity<>(recruiterService.getById(recruiterId), HttpStatus.OK);
    }


    @PostMapping("/{recruiterId}/work-experience")
    public ResponseEntity<Void> appendWorkExperience(@PathVariable String recruiterId, @RequestBody WorkExperienceDTO experienceDTO) {
        recruiterService.appendWorkExperience(recruiterId, experienceDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{recruiterId}/work-experience")
    public ResponseEntity<List<WorkExperienceDTO>> getWorkExperience(@PathVariable String recruiterId) {
        return new ResponseEntity<>(recruiterService.getAllWorkExperiences(recruiterId), HttpStatus.OK);
    }
}
