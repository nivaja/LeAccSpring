package com.lemon.leacc.leacc1.Auth;

import com.lemon.leacc.leacc1.Auth.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByUsername(String username);
}
