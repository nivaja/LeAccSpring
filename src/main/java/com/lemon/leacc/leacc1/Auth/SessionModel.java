package com.lemon.leacc.leacc1.Auth;

import com.lemon.leacc.leacc1.Model.FiscalAccount;

public class SessionModel {
    private User user;
    private Company company;
    private FiscalAccount fiscalAccount;

    public SessionModel(User user, Company company, FiscalAccount fiscalAccount) {
        this.user = user;
        this.company = company;
        this.fiscalAccount = fiscalAccount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
