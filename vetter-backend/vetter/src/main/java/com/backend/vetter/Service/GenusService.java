package com.backend.vetter.Service;

import com.backend.vetter.DTO.GenusDTO;
import com.backend.vetter.Entity.Genus;
import com.backend.vetter.Entity.Pet;
import com.backend.vetter.MapperImpl.GenusMapperImpl;
import com.backend.vetter.Repository.GenusRepository;
import com.backend.vetter.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenusService {

    @Autowired
    GenusRepository genusRepository;
    @Autowired
    PetRepository petRepository;

    public Boolean delete(Long id){
        List<Pet> petList = petRepository.findByGenusId_id(id);
        petList.stream().forEach(pet -> {
            petRepository.deleteById(pet.getId());
        });

        genusRepository.deleteById(id);

        return true;
    }

    public GenusDTO add(GenusDTO genusDTO){
        Genus savedGenus = genusRepository.save(GenusMapperImpl.toEntity(genusDTO));
        genusDTO.setGenus(savedGenus.getGenus());

        return genusDTO;
    }

    public List<GenusDTO> getAll(){
        List<GenusDTO> genusDTOList = new ArrayList<>();
        genusRepository.findAll().stream().forEach(genus -> {
            genusDTOList.add(GenusMapperImpl.toDTO(genus));
        });
        return genusDTOList;
    }
}
