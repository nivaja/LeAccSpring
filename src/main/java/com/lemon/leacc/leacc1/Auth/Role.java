package com.lemon.leacc.leacc1.Auth;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="roleId")
public class Role implements Serializable {
    @Id
    @GeneratedValue
    private int roleId;
    private String roleDescription;

    @JsonIgnore
    @JsonManagedReference
    @JsonBackReference
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<User> users;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
