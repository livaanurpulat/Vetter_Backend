package com.backend.vetter.Entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Table
@Entity

public class Treatment implements Serializable {

    @Id
    @GeneratedValue(generator = "vetter-generator", strategy = GenerationType.SEQUENCE )
    @SequenceGenerator(name = "vetter-generator", allocationSize = 50, sequenceName = "vetter_seq")
    private Long id;

    @Column
    private String type;

    @Column
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "vaccinationId")
    private Vaccination vaccinationId;

    public Treatment(){

    }


}
