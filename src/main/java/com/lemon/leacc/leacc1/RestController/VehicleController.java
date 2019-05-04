package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.Vehicle;
import com.lemon.leacc.leacc1.RestRepo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    SessionService sessionService;

    @PostMapping("/add")
    public void addCustomer(@Valid @RequestBody Vehicle vehicle){
        vehicle.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        vehicleRepo.save(vehicle);
    }
}
