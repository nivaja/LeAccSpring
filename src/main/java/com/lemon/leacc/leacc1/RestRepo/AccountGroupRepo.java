package com.lemon.leacc.leacc1.RestRepo;


import com.lemon.leacc.leacc1.Model.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountGroupRepo extends JpaRepository<AccountGroup,Integer> {
}
