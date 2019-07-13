package com.lemon.leacc.leacc1.Auth;

import com.lemon.leacc.leacc1.Model.FiscalAccount;

public class SessionModel {
    private AppUser user;
    private Company company;
    private FiscalAccount fiscalAccount;

    public SessionModel(AppUser user, Company company, FiscalAccount fiscalAccount) {
        this.user = user;
        this.company = company;
        this.fiscalAccount = fiscalAccount;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
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
