package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.TreatmentDTO;
import com.backend.vetter.DTO.VaccinationDTO;
import com.backend.vetter.Entity.Treatment;
import com.backend.vetter.Entity.Vaccination;

import java.util.ArrayList;
import java.util.List;

public class VaccinationMapperImpl {
    public static VaccinationDTO toDTO(Vaccination vaccinationEntity){
        VaccinationDTO vaccinationDTO = new VaccinationDTO();
        List<TreatmentDTO> treatmentDTOList = new ArrayList<>();

        vaccinationDTO.setId(vaccinationEntity.getId());
        vaccinationDTO.setPrice(vaccinationEntity.getPrice());
        vaccinationDTO.setType(vaccinationEntity.getType());

        vaccinationEntity.getTreatments().forEach(treatment -> {
            treatmentDTOList.add(TreatmentMapperImpl.toDTO(treatment));
        });
        vaccinationDTO.setTreatments(treatmentDTOList);

        return vaccinationDTO;
    }

    public static Vaccination toEntity(VaccinationDTO vaccinationDTO){
        Vaccination vaccinationEntity = new Vaccination();

        if(vaccinationDTO.getId() != null){
            vaccinationEntity.setId(vaccinationDTO.getId());
        }

        vaccinationEntity.setPrice(vaccinationDTO.getPrice());
        vaccinationEntity.setType(vaccinationDTO.getType());

        return vaccinationEntity;

    }
}
