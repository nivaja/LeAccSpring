package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountGroup implements Serializable {
    @GeneratedValue
    @Id
    private int AccountGroupId;
    private String AccountGroupDescription;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "accountGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountType> accountTypes=new ArrayList<AccountType>();

    public int getAccountGroupId() {
        return AccountGroupId;
    }

    public void setAccountGroupId(int accountGroupId) {
        AccountGroupId = accountGroupId;
    }

    public String getAccountGroupDescription() {
        return AccountGroupDescription;
    }

    public void setAccountGroupDescription(String accountGroupDescription) {
        AccountGroupDescription = accountGroupDescription;
    }

    public List<AccountType> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(List<AccountType> accountTypes) {
        this.accountTypes = accountTypes;
    }
}