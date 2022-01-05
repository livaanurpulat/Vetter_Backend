package com.backend.vetter.MapperImpl;

import com.backend.vetter.DTO.CustomerDTO;
import com.backend.vetter.DTO.PetDTO;
import com.backend.vetter.Entity.Customer;
import com.backend.vetter.Entity.Pet;

public class CustomerMapperImpl {
    public static CustomerDTO toDTO(Customer customerEntity){
        CustomerDTO customerDTO = new CustomerDTO();
        PetDTO petDTO = PetMapperImpl.toDTO(customerEntity.getPetId());

        customerDTO.setId(customerEntity.getId());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setAddress(customerEntity.getAddress());
        customerDTO.setDebit(customerEntity.getDebit());
        customerDTO.setDescription(customerEntity.getDescription());
        customerDTO.setPhone(customerEntity.getPhone());
        customerDTO.setSurname(customerEntity.getSurname());
        customerDTO.setPetId(petDTO);

        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO){
        Customer customerEntity = new Customer();
        Pet petEntity = PetMapperImpl.toEntity(customerDTO.getPetId());

        if(customerDTO.getId() != null){
            customerEntity.setId(customerDTO.getId());
        }

        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setDebit(customerDTO.getDebit());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setSurname(customerDTO.getSurname());
        customerEntity.setDescription(customerDTO.getDescription());
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setPetId(petEntity);

        return customerEntity;
    }
}
