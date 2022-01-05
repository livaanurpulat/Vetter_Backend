package com.backend.vetter.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
@ToString

public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "vetter-generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="vetter-generator", allocationSize = 50, sequenceName = "vetter_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private Double debit;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn
    private Pet petId;

    public Customer(){

    }
}
