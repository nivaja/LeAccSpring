package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.Vehicle;
import com.lemon.leacc.leacc1.RestRepo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    SessionService sessionService;

    @PostMapping("/add")
    public void add(@Valid @RequestBody Vehicle vehicle){
        vehicle.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        vehicleRepo.save(vehicle);
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        vehicleRepo.delete(vehicle);
        model.addAttribute("vehicles", vehicleRepo.findAll());
        return "transportation";
    }

}
