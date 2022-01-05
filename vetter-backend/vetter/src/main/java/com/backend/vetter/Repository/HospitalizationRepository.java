package com.backend.vetter.Repository;

import com.backend.vetter.Entity.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalizationRepository extends JpaRepository<Hospitalization,Long> {

    List<Hospitalization> findByCageId_id(Long id);
    List<Hospitalization> findByConsultationId_id(Long id);
}
