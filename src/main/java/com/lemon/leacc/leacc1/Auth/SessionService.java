package com.lemon.leacc.leacc1.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {
    @Autowired
    UserRepo userRepo;

   public SessionModel getCurrentUserSession(){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       UserPrincipal authUser = (UserPrincipal) auth.getPrincipal();
       Optional<AppUser> optionalUser = userRepo.findByUsername(authUser.getUsername());
       if (!optionalUser.isPresent()){
           throw  new RuntimeException("USER NOT FOUND");
       }
       AppUser user=  optionalUser.get();
       if(((user.getCompany().getFiscalAccounts()).size() == 1)){
           System.out.println(user.getUsername()+", "+user.getCompany().getCompanyId()+", "+ user.getCompany().getFiscalAccounts());
           return new SessionModel(user,user.getCompany(),user.getCompany().getFiscalAccounts().get(0));
       }
       throw new RuntimeException("FISCAL ACCOUNT NOT FOUND");
   }
}
