package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.TreatmentDTO;
import com.backend.vetter.DTO.VaccinationDTO;
import com.backend.vetter.Entity.Treatment;
import com.backend.vetter.Entity.Vaccination;

public class TreatmentMapperImpl {

    public static TreatmentDTO toDTO(Treatment treatmentEntity){
        TreatmentDTO treatmentDTO = new TreatmentDTO();

//        VaccinationDTO vaccinationDTO = VaccinationMapperImpl.toDTO(treatmentEntity.getVaccinationId());

        treatmentDTO.setId(treatmentEntity.getId());
        treatmentDTO.setType(treatmentEntity.getType());
        treatmentDTO.setCost(treatmentEntity.getCost());
//        treatmentDTO.setVaccinationId(vaccinationDTO);

        return treatmentDTO;
    }

    public static Treatment toEntity(TreatmentDTO treatmentDTO){
        Treatment treatmentEntity = new Treatment();

        Vaccination vaccinationEntity = VaccinationMapperImpl.toEntity(treatmentDTO.getVaccinationId());

        if(treatmentDTO.getId() != null){
            treatmentEntity.setId(treatmentDTO.getId());
        }

        treatmentEntity.setType(treatmentDTO.getType());
        treatmentEntity.setCost(treatmentDTO.getCost());
        treatmentEntity.setVaccinationId(vaccinationEntity);

        return treatmentEntity;
    }
}
