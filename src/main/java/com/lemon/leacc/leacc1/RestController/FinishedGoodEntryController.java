package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.FinishedGoodEntry;
import com.lemon.leacc.leacc1.RestRepo.FinishedGoodEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/finishedGoodEntry")
public class FinishedGoodEntryController {
    @Autowired
    SessionService sessionService;
    @Autowired
    FinishedGoodEntryRepo finishedGoodEntryRepo;


    @RequestMapping("/add")
    public void addFinishedGoodEntry(@RequestBody FinishedGoodEntry finishedGoodEntry){

        finishedGoodEntry.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        finishedGoodEntry.getFinishedGoodEntryProducts().forEach(enrty -> enrty.setFinishedGoodEntry(finishedGoodEntry));
        System.out.println(finishedGoodEntry);
        finishedGoodEntryRepo.save(finishedGoodEntry);
    }

    @GetMapping("/get/{id}")
    public FinishedGoodEntry getById(@PathVariable int id){
        return finishedGoodEntryRepo.getOne(id);
    }

    @GetMapping("/get/all")
    public List<FinishedGoodEntry> getById(){
        return finishedGoodEntryRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
    }
}
