package com.backend.vetter.Repository;

import com.backend.vetter.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {

    List<Pet> findByGenusId_id(Long id);
}
