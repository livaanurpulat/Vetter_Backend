package com.backend.vetter.DTO;

import lombok.Data;

import java.util.Date;

@Data

public class ConsultationDTO {
    private Long id;
    private Date date;
    private String diagnosis;
    private TreatmentDTO treatmentId;
    private PetDTO petId;

    public ConsultationDTO(){

    }
}
