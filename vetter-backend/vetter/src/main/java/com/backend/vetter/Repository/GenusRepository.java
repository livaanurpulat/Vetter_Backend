package com.backend.vetter.Repository;

import com.backend.vetter.Entity.Genus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenusRepository extends JpaRepository<Genus,Long> {

}
