package com.redwoodgroup.petstore.dbModels;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "visits")
public class VisitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="visits_id_seq" )
    @SequenceGenerator(name = "visits_id_seq",sequenceName = "visits_id_seq",allocationSize = 1)
    private Integer id;

    private String description;
    @CreationTimestamp
    private Timestamp visit_date;
    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public Timestamp getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Timestamp visit_date) {
        this.visit_date = visit_date;
    }
}
