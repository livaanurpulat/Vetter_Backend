package com.backend.vetter.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString

public class VaccinationDTO {
    private Long id;
    private String type;
    private Double price;
    private List<TreatmentDTO> treatments;

    public VaccinationDTO(){

    }
}
