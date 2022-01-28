package com.trialdex.dex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subject", schema = "public")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private Orientation sex;
    private String hospitalId;
    private Integer groupId;
    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private Set<Trial> belongsTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Orientation getSex() {
        return sex;
    }

    public void setSex(Orientation sex) {
        this.sex = sex;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Set<Trial> getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Set<Trial> belongsTo) {
        this.belongsTo = belongsTo;
    }
}
