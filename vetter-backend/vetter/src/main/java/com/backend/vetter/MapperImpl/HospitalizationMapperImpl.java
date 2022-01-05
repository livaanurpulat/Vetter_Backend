package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.CageDTO;
import com.backend.vetter.DTO.ConsultationDTO;
import com.backend.vetter.DTO.HospitalizationDTO;
import com.backend.vetter.Entity.Cage;
import com.backend.vetter.Entity.Consultation;
import com.backend.vetter.Entity.Hospitalization;

public class HospitalizationMapperImpl {
    public static HospitalizationDTO toDTO(Hospitalization hospitalizationEntity){
        HospitalizationDTO hospitalizationDTO = new HospitalizationDTO();
        CageDTO cageDTO = CageMapperImpl.toDTO(hospitalizationEntity.getCageId());
        ConsultationDTO consultationDTO = ConsultationMapperImpl.toDTO(hospitalizationEntity.getConsultationId());

        hospitalizationDTO.setId(hospitalizationEntity.getId());
        hospitalizationDTO.setCost(hospitalizationEntity.getCost());
        hospitalizationDTO.setDepartureDate(hospitalizationEntity.getDepartureDate());
        hospitalizationDTO.setEntryDate(hospitalizationEntity.getEntryDate());
        hospitalizationDTO.setCageId(cageDTO);
        hospitalizationDTO.setConsultationId(consultationDTO);

        return hospitalizationDTO;
    }

    public static Hospitalization toEntity(HospitalizationDTO hospitalizationDTO){
        Hospitalization hospitalizationEntity = new Hospitalization();
        Cage cageEntity = CageMapperImpl.toEntity(hospitalizationDTO.getCageId());
        Consultation consultationEntity = ConsultationMapperImpl.toEntity(hospitalizationDTO.getConsultationId());

        if(hospitalizationDTO.getId() != null){
            hospitalizationEntity.setId(hospitalizationDTO.getId());
        }

        hospitalizationEntity.setCost(hospitalizationDTO.getCost());
        hospitalizationEntity.setDepartureDate(hospitalizationDTO.getDepartureDate());
        hospitalizationEntity.setEntryDate(hospitalizationDTO.getEntryDate());
        hospitalizationEntity.setCageId(cageEntity);
        hospitalizationEntity.setConsultationId(consultationEntity);

        return hospitalizationEntity;
    }
}
