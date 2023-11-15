package br.com.everymind.jog.vacancies.repository;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<PersonDTO, String> {

    PersonDTO findByEmail(String email);

    @Query("{$or: [" +
            "{'name': {$regex: ?0, $options: 'i'}}," +
            "{'email': {$regex: ?0, $options: 'i'}}," +
            "{'phoneNumber': {$regex: ?0, $options: 'i'}}," +
            "{'about': {$regex: ?0, $options: 'i'}}," +
            "{'city': {$regex: ?0, $options: 'i'}}," +
            "{'state': {$regex: ?0, $options: 'i'}}," +
            "{'socialVulnerability': {$regex: ?0, $options: 'i'}}," +
            "{'skillsDTOS.skill': {$regex: ?0, $options: 'i'}}," +
            "{'skillsDTOS.competency': {$regex: ?0, $options: 'i'}}," +
            "{'coursesDTOS.institution': {$regex: ?0, $options: 'i'}}," +
            "{'coursesDTOS.course': {$regex: ?0, $options: 'i'}}," +
            "{'coursesDTOS.urlValidateCredential': {$regex: ?0, $options: 'i'}}," +
            "{'coursesDTOS.credentialCode': {$regex: ?0, $options: 'i'}}," +
            "{'degreeDTOS.institution': {$regex: ?0, $options: 'i'}}," +
            "{'degreeDTOS.course': {$regex: ?0, $options: 'i'}}," +
            "{'degreeDTOS.degree': {$regex: ?0, $options: 'i'}}," +
            "{'degreeDTOS.end': {$regex: ?0, $options: 'i'}}," +
            "{'workExperienceDTOS.company': {$regex: ?0, $options: 'i'}}," +
            "{'workExperienceDTOS.time': {$regex: ?0, $options: 'i'}}," +
            "{'workExperienceDTOS.role': {$regex: ?0, $options: 'i'}}," +
            "{'workExperienceDTOS.description': {$regex: ?0, $options: 'i'}}" +
            "]}")
    List<PersonDTO> search(String searchText);
}
