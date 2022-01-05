package com.backend.vetter.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Data
@Entity
@ToString

public class Cage implements Serializable {

    @Id
    @GeneratedValue(generator = "vetter-generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vetter-generator", allocationSize = 50, sequenceName = "vetter_seq")
    private Long id;

    @Column
    private String name;

    public Cage(){

    }
}
