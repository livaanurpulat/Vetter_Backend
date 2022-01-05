package com.backend.vetter.Repository;

import com.backend.vetter.Entity.Treatment;
import com.backend.vetter.Entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment,Long> {

    List<Treatment> findByVaccinationId(Long id);
}
