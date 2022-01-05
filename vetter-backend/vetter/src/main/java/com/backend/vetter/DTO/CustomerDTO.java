package com.backend.vetter.DTO;

import lombok.Data;

@Data

public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Double debit;
    private String description;
    private PetDTO petId;

    public CustomerDTO(){

    }
}
