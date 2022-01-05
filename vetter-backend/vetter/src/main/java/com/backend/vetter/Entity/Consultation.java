package com.backend.vetter.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@ToString
@Table

public class Consultation implements Serializable {

    @Id
    @GeneratedValue(generator = "vetter-generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vetter-generator", allocationSize = 50, sequenceName = "vetter_seq")
    private Long id;

    @Column
    private String diagnosis;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn
    private Pet petId;

    @ManyToOne
    @JoinColumn
    private Treatment treatmentId;

    public Consultation(){

    }
}
