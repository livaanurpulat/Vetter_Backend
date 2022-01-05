package com.backend.vetter.Service;

import com.backend.vetter.DTO.PetDTO;
import com.backend.vetter.Entity.Consultation;
import com.backend.vetter.Entity.Customer;
import com.backend.vetter.Entity.Pet;
import com.backend.vetter.MapperImpl.PetMapperImpl;
import com.backend.vetter.Repository.ConsultationRepository;
import com.backend.vetter.Repository.CustomerRepository;
import com.backend.vetter.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    ConsultationRepository consultationRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Boolean delete(Long id){

        List<Consultation> consultationList = consultationRepository.findByPetId_id(id);
        consultationList.stream().forEach(consultation -> {
            consultationRepository.deleteById(consultation.getId());
        });

        List<Customer> customerList = customerRepository.findByPetId_id(id);
        customerList.stream().forEach(customer -> {
            customerRepository.deleteById(customer.getId());
        });

        petRepository.deleteById(id);

        return true;
    }

    public PetDTO add(PetDTO petDTO){
        Pet savedPet = petRepository.save(PetMapperImpl.toEntity(petDTO));
        petDTO.setId(savedPet.getId());

        return petDTO;
    }

    public List<PetDTO> getAll(){
        List<PetDTO>petDTOList = new ArrayList<>();
        petRepository.findAll().stream().forEach(pet -> {
            petDTOList.add(PetMapperImpl.toDTO(pet));
        });
        return petDTOList;
    }
}
