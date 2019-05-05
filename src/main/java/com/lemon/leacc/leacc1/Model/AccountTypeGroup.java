package com.lemon.leacc.leacc1.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

//@Entity
public class AccountTypeGroup implements Serializable {
   // @Id
    private int accountTypeGroupId;

    private String accountTypeGroupDescription;

   // @OneToMany(mappedBy = "accountTypeGroup")
    private List<Account> accounts;

    public int getAccountTypeGroupId() {
        return accountTypeGroupId;
    }

    public void setAccountTypeGroupId(int accountTypeGroupId) {
        this.accountTypeGroupId = accountTypeGroupId;
    }

    public String getAccountTypeGroupDescription() {
        return accountTypeGroupDescription;
    }

    public void setAccountTypeGroupDescription(String accountTypeGroupDescription) {
        this.accountTypeGroupDescription = accountTypeGroupDescription;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
