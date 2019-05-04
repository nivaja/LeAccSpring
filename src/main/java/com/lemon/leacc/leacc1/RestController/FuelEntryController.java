package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.FuelEntry;
import com.lemon.leacc.leacc1.RestRepo.FuelEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fuelEntry")
public class FuelEntryController {
    @Autowired
    FuelEntryRepo fuelEntryRepo;
    @Autowired
    SessionService sessionService;

    @PostMapping("/add")
    public void addFuelEntry(@RequestBody FuelEntry fuelEntry){
        fuelEntry.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        fuelEntryRepo.save(fuelEntry);
    }
}
