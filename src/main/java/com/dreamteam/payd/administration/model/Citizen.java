package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Citizen implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String initials;
    @NotNull
    private String firstName;
    private String preposition;
    @NotNull
    private String lastName;

    @OneToMany
    private List<Invoice> invoices;

    protected Citizen() {
        this.invoices = new ArrayList<>();
    }

    public Citizen(String firstName, String lastName) {
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
