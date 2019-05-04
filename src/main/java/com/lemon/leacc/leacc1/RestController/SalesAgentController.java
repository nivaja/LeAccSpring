package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.SalesAgent;
import com.lemon.leacc.leacc1.RestRepo.SalesAgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/salesAgent")
public class SalesAgentController {
    @Autowired
    SalesAgentRepo salesAgentRepo;
    @Autowired
    SessionService sessionService;

    @PostMapping("/add")
    public void addSalesAgent(@Valid @RequestBody SalesAgent salesAgent){
        salesAgent.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        salesAgentRepo.save(salesAgent);
    }
}
