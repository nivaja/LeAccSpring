package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Godown;
import com.lemon.leacc.leacc1.RestRepo.GodownRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/godown")
public class GodownController {
    @Autowired
    GodownRepo godownRepo;
    @Autowired
    SessionService sessionService;

    @PostMapping("/add")
    public void addGodown(@RequestBody Godown godown){
        godown.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        godownRepo.save(godown);
    }
}
