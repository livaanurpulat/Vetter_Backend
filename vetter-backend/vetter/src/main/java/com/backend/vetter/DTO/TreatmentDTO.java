package com.backend.vetter.DTO;

import com.backend.vetter.Entity.Vaccination;
import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class TreatmentDTO {

    private Long id;
    private String type;
    private Double cost;
    private VaccinationDTO vaccinationId;


    public TreatmentDTO(){

    }
}
