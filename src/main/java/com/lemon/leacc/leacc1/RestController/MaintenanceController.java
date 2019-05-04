package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.MaintenanceEntry;
import com.lemon.leacc.leacc1.RestRepo.MaintenanceEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/maintenanceEntry")
public class MaintenanceController {
    @Autowired
    SessionService sessionService;

    @Autowired
    MaintenanceEntryRepo maintenanceEntryRepo;


    @PostMapping("/add")
    public void addMaintenanceEntry(@RequestBody MaintenanceEntry maintenanceEntry){
        maintenanceEntry.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        maintenanceEntryRepo.save(maintenanceEntry);
    }
}
