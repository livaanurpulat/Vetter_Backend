package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.GenusDTO;
import com.backend.vetter.Entity.Genus;

public class GenusMapperImpl {

    public static GenusDTO toDTO(Genus genusEntity){
        GenusDTO genusDTO = new GenusDTO();

        genusDTO.setId(genusEntity.getId());
        genusDTO.setGenus(genusEntity.getGenus());

        return genusDTO;
    }

    public static Genus toEntity(GenusDTO genusDTO){
        Genus genusEntity = new Genus();
        if(genusDTO.getId() != null){
            genusEntity.setId(genusDTO.getId());
        }
        genusEntity.setGenus(genusDTO.getGenus());

        return genusEntity;
    }
}
