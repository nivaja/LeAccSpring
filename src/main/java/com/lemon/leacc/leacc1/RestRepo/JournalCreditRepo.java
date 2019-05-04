package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Journal;
import com.lemon.leacc.leacc1.Model.JournalCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalCreditRepo extends JpaRepository<JournalCredit,Integer> {
}
