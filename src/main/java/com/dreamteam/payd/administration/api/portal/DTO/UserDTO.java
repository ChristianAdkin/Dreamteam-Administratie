package com.dreamteam.payd.administration.api.portal.DTO;

import java.util.Date;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class UserDTO {

    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private Date dateofbirth;

    public UserDTO(Long id, String email, String firstname, String lastname, Date dateofbirth) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
