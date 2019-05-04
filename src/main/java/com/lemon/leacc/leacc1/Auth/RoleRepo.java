package com.lemon.leacc.leacc1.Auth;

import com.lemon.leacc.leacc1.Auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer>{
    Role getByRoleDescription(String description);
}
