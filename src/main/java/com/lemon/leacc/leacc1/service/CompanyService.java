package com.lemon.leacc.leacc1.service;

import com.lemon.leacc.leacc1.Auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService{
    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    UserRepo userRepo;

    public void registerCompany(Company company){
        User user = new User();
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepo.getByRoleDescription("ADMIN"));
        roles.add(roleRepo.getByRoleDescription("COMPANY"));
        user.setUsername(company.getCompanyInitial());
        user.setPassword(company.getPassword());
        user.setCompany(company);
        user.setEmail(company.getEmail());
        user.setRoles(roles);

        companyRepo.save(company);
        userRepo.save(user);
    }
}
