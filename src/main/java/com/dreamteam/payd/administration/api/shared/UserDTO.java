package com.dreamteam.payd.administration.api.shared;

import java.util.Date;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class UserDTO {

    private Long id;

    private String idNumber;
    private String email;
    private String initials;
    private String firstname;
    private String preposition;
    private String lastname;
    private Date dateofbirth;

    public UserDTO() {

    }

    public UserDTO(Long id, String idNumber, String email, String initials, String firstname, String preposition, String lastname, Date dateofbirth) {
        this.id = id;
        this.idNumber = idNumber;
        this.email = email;
        this.initials = initials;
        this.firstname = firstname;
        this.preposition = preposition;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
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
