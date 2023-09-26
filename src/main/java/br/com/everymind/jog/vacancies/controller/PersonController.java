package br.com.everymind.jog.vacancies.controller;

import br.com.everymind.jog.vacancies.model.dto.*;
import br.com.everymind.jog.vacancies.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody @Validated PersonDTO personDTO) {
        return new ResponseEntity<>(personService.save(personDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    //Courses
    @PostMapping("/{personId}/course")
    public ResponseEntity<Void> appendCourse(@PathVariable String personId, @RequestBody CoursesDTO coursesDTO) {
        personService.appendCourse(personId, coursesDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{personId}/course")
    public ResponseEntity<List<CoursesDTO>> getCourses(@PathVariable String personId) {
        return new ResponseEntity<>(personService.getAllCourses(personId), HttpStatus.OK);
    }

    //Skills
    @PostMapping("/{personId}/skills")
    public ResponseEntity<Void> appendSkill(@PathVariable String personId, @RequestBody SkillsDTO skillsDTO) {
        personService.appendSkill(personId, skillsDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{personId}/skills")
    public ResponseEntity<List<SkillsDTO>> getSkills(@PathVariable String personId) {
        return new ResponseEntity<>(personService.getAllSkills(personId), HttpStatus.OK);
    }


    //Degree
    @PostMapping("/{personId}/degree")
    public ResponseEntity<Void> appendDegree(@PathVariable String personId, @RequestBody DegreeDTO degreeDTO) {
        personService.appendDegree(personId, degreeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{personId}/degree")
    public ResponseEntity<List<DegreeDTO>> getDegree(@PathVariable String personId) {
        return new ResponseEntity<>(personService.getAllDegrees(personId), HttpStatus.OK);
    }


    //Work Experience
    @PostMapping("/{personId}/work-experience")
    public ResponseEntity<Void> appendWorkExperience(@PathVariable String personId, @RequestBody WorkExperienceDTO experienceDTO) {
        personService.appendWorkExperience(personId, experienceDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{personId}/work-experience")
    public ResponseEntity<List<WorkExperienceDTO>> getWorkExperience(@PathVariable String personId) {
        return new ResponseEntity<>(personService.getAllWorkExperiences(personId), HttpStatus.OK);
    }

    @PostMapping("/{personId}/social-vulnerability")
    public ResponseEntity<Void> appendWorkExperience(@RequestParam String socialVulnerability, @PathVariable String personId) {
        personService.appendSocialVulnerability(personId, socialVulnerability);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{personId}/vacancy")
    public ResponseEntity<List<VacancyDTO>> getVacancys(@PathVariable String personId) {
        return new ResponseEntity<>(personService.getAllVacancys(personId), HttpStatus.OK);
    }

    @PostMapping("/{personId}/vacancy")
    public ResponseEntity<Void> appendVacancy(@RequestParam String vacancyId, @PathVariable String personId) {
        personService.appendVacancy(personId, vacancyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/find")
    public ResponseEntity<List<PersonDTO>> findByParameters(@RequestParam(required = false) Integer age,
                                        @RequestParam(required = false) String city,
                                        @RequestParam(required = false) String socialVulnerability) {
        return new ResponseEntity<>(personService.findByParameters(age, city, socialVulnerability), HttpStatus.OK);
    }
}
