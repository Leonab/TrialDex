package com.trialdex.dex.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trial", schema = "public")
public class Trial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Long ownerId;
    private String trialName;
    private String description;
    private Integer noOfGroups;
    @ManyToMany
    @JoinTable(
            name = "trialsubjectmap",
            joinColumns = @JoinColumn(
                    name = "trialId",
                    referencedColumnName = "id",
                    nullable = false
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "subjectId",
                    referencedColumnName = "id",
                    nullable = false
            )
    )
    private Set<Subject> subjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTrialName() {
        return trialName;
    }

    public void setTrialName(String trialName) {
        this.trialName = trialName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNoOfGroups() {
        return noOfGroups;
    }

    public void setNoOfGroups(Integer noOfGroups) {
        this.noOfGroups = noOfGroups;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
