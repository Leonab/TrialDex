package com.trialdex.dex.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    private Long id;
    private LocalDateTime createdate;
    private String firstname;
    private String lastname;
    private String email;

    public User() {
    }

    public User(Long id, String firstname, String lastname, LocalDateTime createdate, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdate = createdate;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
