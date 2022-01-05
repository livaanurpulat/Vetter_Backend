package com.backend.vetter.Service;

import com.backend.vetter.DTO.TreatmentDTO;
import com.backend.vetter.DTO.VaccinationDTO;
import com.backend.vetter.Entity.Treatment;
import com.backend.vetter.Entity.Vaccination;
import com.backend.vetter.MapperImpl.VaccinationMapperImpl;
import com.backend.vetter.Repository.TreatmentRepository;
import com.backend.vetter.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationService {

    @Autowired
    VaccinationRepository vaccinationRepository;

    @Autowired
    TreatmentRepository treatmentRepository;

    public Boolean delete(Long id){

        List<Treatment> treatmentList = treatmentRepository.findByVaccinationId(id);
        treatmentList.stream().forEach(treatment -> {
            treatmentRepository.deleteById(treatment.getId());
        });

        vaccinationRepository.deleteById(id);
        return true;
    }

    public VaccinationDTO add(VaccinationDTO vaccinationDTO){
        Vaccination savedVaccination = vaccinationRepository.save(VaccinationMapperImpl.toEntity(vaccinationDTO));
        vaccinationDTO.setId(savedVaccination.getId());

        return vaccinationDTO;
    }

    public List<VaccinationDTO> getAll(){
        List<VaccinationDTO> vaccinationDTOList = new ArrayList<>();
        vaccinationRepository.findAll().stream().forEach( vaccination -> {
            vaccinationDTOList.add(VaccinationMapperImpl.toDTO(vaccination));
        });
/*
        vaccinationRepository.findAll().stream().forEach(vaccination -> {
            VaccinationDTO vaccinationDTO = new VaccinationDTO();
            List<TreatmentDTO> treatmentDTOList = new ArrayList<>();

            vaccination.setId(vaccination.getId());
            vaccinationDTO.setPrice(vaccination.getPrice());
            vaccinationDTO.setType(vaccination.getType());

            vaccination.getTreatments().stream().forEach(treatment -> {

                TreatmentDTO treatmentDTO = new TreatmentDTO();
                treatmentDTO.setId(treatment.getId());
                treatmentDTO.setCost(treatment.getCost());
                treatmentDTO.setType(treatment.getType());
                treatmentDTOList.add(treatmentDTO);

            });
            vaccinationDTO.setTreatments(treatmentDTOList);
            vaccinationDTOList.add(vaccinationDTO);
        });*/
        return vaccinationDTOList;
    }

}
