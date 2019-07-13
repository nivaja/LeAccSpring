package com.lemon.leacc.leacc1.Auth;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="userId")
public class AppUser implements Serializable {
        @GeneratedValue
        @Id
        private int userId;
        @Column(unique = true, nullable = false)
        private String username;
        private String password;
        private String email;


        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @JoinColumn(name = "company_id")
        private Company Company;

        @JsonIgnore
        @JsonBackReference
        @JsonManagedReference
        @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private List<Role> roles;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public com.lemon.leacc.leacc1.Auth.Company getCompany() {
        return Company;
    }

    public void setCompany(com.lemon.leacc.leacc1.Auth.Company company) {
        Company = company;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
