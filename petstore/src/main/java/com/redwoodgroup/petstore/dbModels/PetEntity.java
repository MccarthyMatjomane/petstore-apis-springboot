package com.redwoodgroup.petstore.dbModels;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="pet_id_seq" )
    @SequenceGenerator(name = "pet_id_seq",sequenceName = "pet_id_seq",allocationSize = 1)
    private Integer id;
    private String name;
    private Timestamp birthDate;
    private Integer status;
    @CreationTimestamp
    private Timestamp createdAt;
    @ManyToOne()
    @JoinColumn(name = "user_id" )
    private UserEntity user;
    @ManyToOne()
    @JoinColumn(name = "type_id")
    private TypeEntity type;
    @OneToMany(mappedBy = "pet",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<VisitEntity> visit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public List<VisitEntity> getVisit() {
        return visit;
    }

    public void setVisit(List<VisitEntity> visit) {
        this.visit = visit;
    }
}
