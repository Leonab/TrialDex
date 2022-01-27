package com.trialdex.dex.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trial", schema = "public")
public class Trial {

    @Id
    private Long id;
    private Long ownerId;
    private String trialName;
    private String description;
    private Integer noOfGroups;

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
}
