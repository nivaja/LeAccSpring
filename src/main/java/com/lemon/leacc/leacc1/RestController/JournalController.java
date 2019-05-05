package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Journal;
import com.lemon.leacc.leacc1.Model.JournalCredit;
import com.lemon.leacc.leacc1.Model.JournalDebit;
import com.lemon.leacc.leacc1.RestRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalController {
    @Autowired
    JournalRepo journalRepo;
    @Autowired
    SessionService sessionService;

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    SubAccountRepo subAccountRepo;
    @PostMapping("/add")
    public void add(@RequestBody Journal journal){
        List<JournalCredit> jcs =new ArrayList<>();
        List<JournalDebit> jds =new ArrayList<>();

        for (JournalCredit jc:journal.getJournalCredits()) {
          //  JournalCredit jd = journalCreditRepo.getOne(jdi.getId());
            if(!(jc.getCreditAmount()==0)){
                jc.setCreditAccount(accountRepo.getOne(jc.getCreditAccount().getAccountId()));
                jc.setCreditSubAccount(subAccountRepo.getOne(jc.getCreditSubAccount().getSubAccountId()));
                jc.setJournal(journal);
                jcs.add(jc);
            }
        }

        for (JournalDebit jd:journal.getJournalDebits()) {
           // JournalDebit jd = journalDebitRepo.getOne(jdi.getId());

            if(!(jd.getDebitAmount()==0)){
                jd.setDebitAccount(accountRepo.getOne(jd.getDebitAccount().getAccountId()));
                jd.setDebitSubAccount(subAccountRepo.getOne(jd.getDebitSubAccount().getSubAccountId()));
                jd.setJournal(journal);
                jds.add(jd);
            }
        }

        journal.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
journal.setJournalCredits(jcs);
journal.setJournalDebits(jds);
        journalRepo.save(journal);
    }
}
