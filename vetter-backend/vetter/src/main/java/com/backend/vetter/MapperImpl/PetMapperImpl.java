package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.GenusDTO;
import com.backend.vetter.DTO.PetDTO;
import com.backend.vetter.Entity.Genus;
import com.backend.vetter.Entity.Pet;

public class PetMapperImpl {

    public static PetDTO toDTO(Pet petEntity){
        PetDTO petDTO = new PetDTO();
        GenusDTO genusDTO = GenusMapperImpl.toDTO(petEntity.getGenusId());

        petDTO.setId(petEntity.getId());
        petDTO.setName(petEntity.getName());
        petDTO.setAge(petEntity.getAge());
        petDTO.setGender(petEntity.getGender());
        petDTO.setGenusId(genusDTO);

        return petDTO;

    }

    public static Pet toEntity(PetDTO petDTO){
        Pet petEntity = new Pet();
        Genus genusEntity = GenusMapperImpl.toEntity(petDTO.getGenusId());

        if(petDTO.getId() != null){
            petEntity.setId(petDTO.getId());
        }

        petEntity.setName(petDTO.getName());
        petEntity.setAge(petDTO.getAge());
        petEntity.setGender(petDTO.getGender());
        petEntity.setGenusId(genusEntity);

        return petEntity;
    }
}
