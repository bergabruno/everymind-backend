package br.com.everymind.jog.vacancies.service.impl;

import br.com.everymind.jog.vacancies.model.dto.PersonDTO;
import br.com.everymind.jog.vacancies.model.dto.RecruiterDTO;
import br.com.everymind.jog.vacancies.model.dto.VacancyDTO;
import br.com.everymind.jog.vacancies.model.dto.WorkExperienceDTO;
import br.com.everymind.jog.vacancies.repository.RecruiterRepository;
import br.com.everymind.jog.vacancies.repository.VacancyRepository;
import br.com.everymind.jog.vacancies.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private VacancyRepository vacancyRepository;


    @Override
    public RecruiterDTO save(RecruiterDTO recruiterDTO) {
        if(recruiterDTO.getPasswordEncrypted() == null) {
            recruiterDTO.setPasswordEncrypted(Base64.getEncoder().encodeToString(recruiterDTO.getPassword().getBytes()));
            recruiterDTO.setPassword(null);
        }
        recruiterDTO = recruiterRepository.save(recruiterDTO);
        return  recruiterDTO;
    }

    @Override
    public RecruiterDTO savePersonalInfo(RecruiterDTO recruiterDTO, String id) {
        RecruiterDTO recruiterDTO1 = getById(id);

        recruiterDTO1.setName(recruiterDTO.getName());
        recruiterDTO1.setPhoneNumber(recruiterDTO.getPhoneNumber());
        recruiterDTO1.setCity(recruiterDTO.getCity());
        recruiterDTO1.setState(recruiterDTO.getState());
        recruiterDTO1.setAge(recruiterDTO.getAge());
        recruiterDTO1.setAbout(recruiterDTO.getAbout());

        save(recruiterDTO1);

        return recruiterDTO1;
    }

    @Override
    public RecruiterDTO getById(String id) {
        RecruiterDTO recruiterDTO =  recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado ninguem com este ID: " + id));

        recruiterDTO.setVagasDivulgadas(recruiterDTO.getVacancyDTOS().size());

        return recruiterDTO;
    }

    @Override
    public void appendWorkExperience(String recruiterId, WorkExperienceDTO workExperienceDTO) {
        RecruiterDTO recruiterDTO = getById(recruiterId);
        recruiterDTO.appendWorkExperience(workExperienceDTO);
        save(recruiterDTO);
    }

    @Override
    public List<WorkExperienceDTO> getAllWorkExperiences(String recruiterId) {
        return getById(recruiterId).getWorkExperienceDTOS();
    }

    @Override
    public void appendVacancy(String recruiterId, VacancyDTO vacancyDTO) {
        vacancyDTO.setRecruiterId(recruiterId);
        vacancyRepository.save(vacancyDTO);

        RecruiterDTO recruiterDTO = getById(recruiterId);
        recruiterDTO.appendVacancy(vacancyDTO);
        save(recruiterDTO);
    }

    @Override
    public List<VacancyDTO> getAllVacancy(String recruiterId) {
        return getById(recruiterId).getVacancyDTOS();
    }

    @Override
    public RecruiterDTO login(RecruiterDTO recruiterDTO) {
        RecruiterDTO recruiterDTO1 = recruiterRepository.findByEmail(recruiterDTO.getEmail());

        if(recruiterDTO1 == null){
            throw  new RuntimeException("Email incorreto");
        }


        byte[] decodedBytes = Base64.getDecoder().decode(recruiterDTO1.getPasswordEncrypted());
        String decodedPassword = new String(decodedBytes);

        if(decodedPassword.equals(recruiterDTO.getPassword())){
            return recruiterDTO1;
        }

        throw  new RuntimeException("Senha errada");
    }
}
