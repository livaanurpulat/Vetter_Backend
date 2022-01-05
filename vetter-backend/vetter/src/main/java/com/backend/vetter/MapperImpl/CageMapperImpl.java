package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.CageDTO;
import com.backend.vetter.Entity.Cage;

public class CageMapperImpl {

    public static CageDTO toDTO(Cage cageEntity){
        CageDTO cageDTO = new CageDTO();

        cageDTO.setId(cageEntity.getId());
        cageDTO.setName(cageEntity.getName());

        return cageDTO;
    }

    public static Cage toEntity(CageDTO cageDTO){
        Cage cageEntity = new Cage();
        if(cageDTO.getId() != null){
            cageEntity.setId(cageDTO.getId());
        }
        cageEntity.setName(cageDTO.getName());

        return cageEntity;
    }
}
