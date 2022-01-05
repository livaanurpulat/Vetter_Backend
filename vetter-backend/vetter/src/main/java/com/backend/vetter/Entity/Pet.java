package com.backend.vetter.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table
@ToString
@Entity

public class Pet implements Serializable {

    @Id
    @GeneratedValue(generator = "vetter-generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vetter-generator", allocationSize = 50, sequenceName = "vetter_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String gender;

    @ManyToOne
    @JoinColumn
    private Genus genusId;

    public Pet(){

    }

}
