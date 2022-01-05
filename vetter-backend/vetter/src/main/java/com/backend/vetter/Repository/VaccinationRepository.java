package com.backend.vetter.Repository;

import com.backend.vetter.Entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository <Vaccination,Long> {
}
