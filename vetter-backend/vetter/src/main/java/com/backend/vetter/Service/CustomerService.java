package com.backend.vetter.Service;

import com.backend.vetter.DTO.CustomerDTO;
import com.backend.vetter.Entity.Customer;
import com.backend.vetter.MapperImpl.CageMapperImpl;
import com.backend.vetter.MapperImpl.CustomerMapperImpl;
import com.backend.vetter.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Boolean delete(Long id){
        customerRepository.deleteById(id);

        return true;
    }

    public CustomerDTO add(CustomerDTO customerDTO){
        Customer savedCustomer = customerRepository.save(CustomerMapperImpl.toEntity(customerDTO));
        customerDTO.setId(savedCustomer.getId());

        return customerDTO;
    }

    public List<CustomerDTO> getAll(){
        List<CustomerDTO>customerDTOList = new ArrayList<>();
        customerRepository.findAll().stream().forEach(customer -> {
            customerDTOList.add(CustomerMapperImpl.toDTO(customer));
        });
        return customerDTOList;
    }
}
