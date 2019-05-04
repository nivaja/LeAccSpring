package com.lemon.leacc.leacc1.Auth;

import com.lemon.leacc.leacc1.Auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
