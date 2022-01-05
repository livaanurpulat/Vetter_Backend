package com.backend.vetter.Repository;

import com.backend.vetter.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

    List<Consultation> findByPetId_id(Long id);
    List<Consultation> findByTreatmentId_id(Long id);
}
