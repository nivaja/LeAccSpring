package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.FinishedProductMap;
import com.lemon.leacc.leacc1.RestRepo.FinishedProductMapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finishedProductMap")
public class FinishedProductMapController {
    @Autowired
    SessionService sessionService;
    @Autowired
    FinishedProductMapRepo finishedProductMapRepo;


    @RequestMapping("/add")
    public void addFinishedProductMap(@RequestBody FinishedProductMap finishedProductMap){
        System.out.println(finishedProductMap);

        finishedProductMap.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        finishedProductMap.getFinishedProductMapItem().forEach(enrty -> enrty.setFinishedProductMap(finishedProductMap));
        System.out.println(finishedProductMap);

        finishedProductMapRepo.save(finishedProductMap);
    }

    @GetMapping("/get/{id}")
    public FinishedProductMap getById(@PathVariable int id){
        return finishedProductMapRepo.getOne(id);
    }

    @GetMapping("/get/all")
    public List<FinishedProductMap> getById(){
        return finishedProductMapRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
    }
}
