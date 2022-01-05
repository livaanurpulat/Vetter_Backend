package com.backend.vetter.Service;


import com.backend.vetter.DTO.HospitalizationDTO;
import com.backend.vetter.Entity.Hospitalization;
import com.backend.vetter.MapperImpl.HospitalizationMapperImpl;
import com.backend.vetter.Repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalizationService {

    @Autowired
    HospitalizationRepository hospitalizationRepository;

    public Boolean delete(Long id){
        hospitalizationRepository.deleteById(id);

        return true;
    }

    public HospitalizationDTO add(HospitalizationDTO hospitalizationDTO){
        Hospitalization savedHospitalization = hospitalizationRepository.save(HospitalizationMapperImpl.toEntity(hospitalizationDTO));
        hospitalizationDTO.setId(savedHospitalization.getId());

        return hospitalizationDTO;
    }

    public List<HospitalizationDTO> getAll(){
        List<HospitalizationDTO> hospitalizationDTOList = new ArrayList<>();
        hospitalizationRepository.findAll().stream().forEach(hospitalization -> {
            hospitalizationDTOList.add(HospitalizationMapperImpl.toDTO(hospitalization));
        });
        return hospitalizationDTOList;
    }
}
