package com.dreamteam.payd.administration.model.auth;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="USER_GROUP",
            joinColumns = @JoinColumn(name = "name",
                    referencedColumnName = "name"),
            inverseJoinColumns = @JoinColumn(name = "emailaddress",
                    referencedColumnName = "emailaddress"))
    private List<User> users;

    protected Role() {
        users = new ArrayList<>();
    }

    public Role(String name) {
        this.name = name;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
