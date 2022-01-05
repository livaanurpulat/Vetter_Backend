package com.backend.vetter.Service;

import com.backend.vetter.DTO.CageDTO;
import com.backend.vetter.Entity.Cage;
import com.backend.vetter.Entity.Hospitalization;
import com.backend.vetter.Entity.Pet;
import com.backend.vetter.MapperImpl.CageMapperImpl;
import com.backend.vetter.Repository.CageRepository;
import com.backend.vetter.Repository.HospitalizationRepository;
import com.backend.vetter.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CageService {

    @Autowired
    CageRepository cageRepository;

    @Autowired
    HospitalizationRepository hospitalizationRepository;

    public Boolean delete(Long id){

        List<Hospitalization> hospitalizationList = hospitalizationRepository.findByCageId_id(id);
        hospitalizationList.stream().forEach(hospitalization -> {
            hospitalizationRepository.deleteById(hospitalization.getId());
        });

        cageRepository.deleteById(id);

        return true;
    }

    public CageDTO add(CageDTO cageDTO){
        Cage savedCage = cageRepository.save(CageMapperImpl.toEntity(cageDTO));
        cageDTO.setId(savedCage.getId());

        return cageDTO;
    }

    public List<CageDTO> getAll(){
        List<CageDTO>cageDTOList = new ArrayList<>();
        cageRepository.findAll().stream().forEach(cage -> {
            cageDTOList.add(CageMapperImpl.toDTO(cage));
        });
        return cageDTOList;
    }
}
