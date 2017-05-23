package com.dreamteam.payd.administration.model;

import com.dreamteam.payd.administration.model.auth.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Citizen implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idNumber;

    private String initials;
    @NotNull
    private String firstName;
    private String preposition;
    @NotNull
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String nationality;
    private String driversLicenceType;

    private String policyNumber;

    private String streetName;
    private String houseNr;
    private String postCode;
    private String city;
    private String country;

    @OneToOne
    private User user;

    @OneToMany
    private List<Invoice> invoices;

    protected Citizen() {
        this.invoices = new ArrayList<>();
    }

    public Citizen(String idNumber ,String firstName, String lastName) {
        this();
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        StringBuilder stringBuilder = new StringBuilder();
        if (initials != null) {
            stringBuilder.append(this.initials);
            stringBuilder.append(" ");
        }
        stringBuilder.append(this.firstName);
        stringBuilder.append(" ");
        if (preposition != null) {
            stringBuilder.append(this.preposition);
            stringBuilder.append(" ");
        }
        stringBuilder.append(this.lastName);
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
       return this.getName();
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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDriversLicenceType() {
        return driversLicenceType;
    }

    public void setDriversLicenceType(String driversLicenceType) {
        this.driversLicenceType = driversLicenceType;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Invoice> getInvoices() {
        return Collections.unmodifiableList(invoices);
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        return id != null ? id.equals(citizen.id) : citizen.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
