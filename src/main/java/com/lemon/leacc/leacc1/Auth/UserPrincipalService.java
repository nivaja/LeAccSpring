package com.lemon.leacc.leacc1.Auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalService implements UserDetailsService{

    private final UserRepo userRepo;
    public UserPrincipalService(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = this.userRepo.findByUsername(username);
        user
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return user
                .map(UserPrincipal::new).get();
    }
}
