package com.backend.vetter.Entity;


import com.backend.vetter.DTO.VaccinationDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table
@ToString
@Data
@Entity

public class Vaccination implements Serializable {

    @Id
    @GeneratedValue(generator = "vetter-generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vetter-generator", allocationSize = 50,sequenceName = "vetter_seq")
    private Long id;

    @Column
    private String type;

    @Column
    private Double price;

    @OneToMany(mappedBy ="vaccinationId",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Treatment> treatments= new ArrayList<>();


    public Vaccination(){

    }
}
