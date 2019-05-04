package com.lemon.leacc.leacc1.service;

import com.lemon.leacc.leacc1.Auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    SessionService sessionService;
    @Autowired
    RoleRepo roleRepo;

    public void save(Map<String, Object> json){
        User user = new User();
        //System.out.println((String)json.get("username"));
        user.setUsername((String)json.get("username"));
        user.setPassword((String)json.get("password"));
        user.setEmail((String)json.get("email"));

        List<Role> roles = new ArrayList<Role>();
      ((List<String>) json.get("roles")).forEach(role -> roles.add(roleRepo.getByRoleDescription(role)));
           roles.add(roleRepo.getByRoleDescription((String) json.get("defaultRole")));
       user.setRoles(roles);
        user.setCompany(sessionService.getCurrentUserSession().getCompany());
       userRepo.save(user);
    }
}
