package com.backend.vetter.DTO;

import lombok.Data;

@Data

public class PetDTO {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private GenusDTO genusId;

    public PetDTO(){

    }
}
