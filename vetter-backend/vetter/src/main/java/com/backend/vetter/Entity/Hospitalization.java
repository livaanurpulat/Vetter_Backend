package com.backend.vetter.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table
@Entity
@ToString

public class Hospitalization implements Serializable {

    @Id
    @GeneratedValue(generator = "vetter-generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="vetter-generator", allocationSize = 50, sequenceName = "vetter_seq")
    private Long id;

    @Column
    private Date entryDate;

    @Column
    private Date departureDate;

    @Column
    private Double cost;

    @OneToOne
    @JoinColumn
    private Cage cageId;

    @OneToOne
    @JoinColumn
    private Consultation consultationId;

    public Hospitalization(){

    }
}
