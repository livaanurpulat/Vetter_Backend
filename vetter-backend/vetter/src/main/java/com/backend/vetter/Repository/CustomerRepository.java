package com.backend.vetter.Repository;

import com.backend.vetter.Entity.Consultation;
import com.backend.vetter.Entity.Customer;
import com.backend.vetter.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByPetId_id(Long id);
}
