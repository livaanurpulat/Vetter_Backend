package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.ConsultationDTO;
import com.backend.vetter.DTO.PetDTO;
import com.backend.vetter.DTO.TreatmentDTO;
import com.backend.vetter.Entity.Consultation;
import com.backend.vetter.Entity.Pet;
import com.backend.vetter.Entity.Treatment;

public class ConsultationMapperImpl {
    public static ConsultationDTO toDTO(Consultation consultationEntity){
        ConsultationDTO consultationDTO = new ConsultationDTO();
        PetDTO petDTO = PetMapperImpl.toDTO(consultationEntity.getPetId());
        TreatmentDTO treatmentDTO = TreatmentMapperImpl.toDTO(consultationEntity.getTreatmentId());

        consultationDTO.setId(consultationEntity.getId());
        consultationDTO.setDate(consultationEntity.getDate());
        consultationDTO.setDiagnosis(consultationEntity.getDiagnosis());
        consultationDTO.setPetId(petDTO);
        consultationDTO.setTreatmentId(treatmentDTO);

        return consultationDTO;
    }

    public static Consultation toEntity(ConsultationDTO consultationDTO){
        Consultation consultationEntity = new Consultation();
        Pet petEntity = PetMapperImpl.toEntity(consultationDTO.getPetId());
        Treatment treatmentEntity = TreatmentMapperImpl.toEntity(consultationDTO.getTreatmentId());

        if(consultationDTO.getId() != null){
            consultationEntity.setId(consultationDTO.getId());
        }

        consultationEntity.setDate(consultationDTO.getDate());
        consultationEntity.setDiagnosis(consultationDTO.getDiagnosis());
        consultationEntity.setPetId(petEntity);
        consultationEntity.setTreatmentId(treatmentEntity);

        return consultationEntity;
    }
}
