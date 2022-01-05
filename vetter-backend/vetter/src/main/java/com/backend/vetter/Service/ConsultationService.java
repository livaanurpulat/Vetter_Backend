package com.backend.vetter.Service;

import com.backend.vetter.DTO.ConsultationDTO;
import com.backend.vetter.Entity.Consultation;
import com.backend.vetter.Entity.Hospitalization;
import com.backend.vetter.MapperImpl.ConsultationMapperImpl;
import com.backend.vetter.Repository.ConsultationRepository;
import com.backend.vetter.Repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    ConsultationRepository consultationRepository;

    @Autowired
    HospitalizationRepository hospitalizationRepository;

    public Boolean delete(Long id){

        List<Hospitalization> hospitalizationList = hospitalizationRepository.findByConsultationId_id(id);
        hospitalizationList.stream().forEach(hospitalization -> {
            hospitalizationRepository.deleteById(hospitalization.getId());
        });

        consultationRepository.deleteById(id);

        return true;
    }

    public ConsultationDTO add(ConsultationDTO consultationDTO){
        Consultation savedConsultation = consultationRepository.save(ConsultationMapperImpl.toEntity(consultationDTO));
        consultationDTO.setId(savedConsultation.getId());

        return consultationDTO;
    }

    public List<ConsultationDTO> getAll(){
        List<ConsultationDTO> consultationDTOList = new ArrayList<>();
        consultationRepository.findAll().stream().forEach(consultation -> {
            consultationDTOList.add(ConsultationMapperImpl.toDTO(consultation));
        });
        return consultationDTOList;
    }
}
