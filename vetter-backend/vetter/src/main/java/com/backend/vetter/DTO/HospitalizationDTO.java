package com.backend.vetter.DTO;

import com.backend.vetter.Entity.Hospitalization;
import lombok.Data;

import java.util.Date;

@Data

public class HospitalizationDTO {
    private Long id;
    private Date entryDate;
    private Date departureDate;
    private Double cost;
    private CageDTO cageId;
    private ConsultationDTO consultationId;

    public HospitalizationDTO(){

    }

}
