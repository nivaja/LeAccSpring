package com.lemon.leacc.leacc1.RestRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepo extends JpaRepository<com.lemon.leacc.leacc1.Model.Journal,Integer>{
}
