package com.backend.vetter.Service;

import com.backend.vetter.DTO.TreatmentDTO;
import com.backend.vetter.Entity.Consultation;
import com.backend.vetter.Entity.Treatment;
import com.backend.vetter.MapperImpl.TreatmentMapperImpl;
import com.backend.vetter.Repository.ConsultationRepository;
import com.backend.vetter.Repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    ConsultationRepository consultationRepository;

    public Boolean delete(Long id){

        List<Consultation> consultationList = consultationRepository.findByTreatmentId_id(id);
        consultationList.stream().forEach(consultation -> {
            consultationRepository.deleteById(consultation.getId());
        });

        treatmentRepository.deleteById(id);

        return true;
    }

    public TreatmentDTO add(TreatmentDTO treatmentDTO){
        Treatment savedTreatment = treatmentRepository.save(TreatmentMapperImpl.toEntity(treatmentDTO));
        treatmentDTO.setId(savedTreatment.getId());

        return treatmentDTO;
    }

    public List<TreatmentDTO> getAll(){
        List<TreatmentDTO> treatmentDTOList = new ArrayList<>();
        treatmentRepository.findAll().stream().forEach(treatment -> {
            treatmentDTOList.add(TreatmentMapperImpl.toDTO(treatment));
        });
        return treatmentDTOList;
    }
}
