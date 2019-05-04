package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Vendor;
import com.lemon.leacc.leacc1.RestRepo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/vendor")
@RestController()
public class VendorController {

    @Autowired
    SessionService sessionService;
    @Autowired
    VendorRepo vendorRepo;

    @PostMapping("/add")
    public void addVendor(@RequestBody Vendor vendor){
       System.out.println(vendor);
        vendor.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        vendorRepo.save(vendor);
    }

    @GetMapping("/getAll")
    public List<Vendor> getAllVendor(){
        return vendorRepo.findAll();
    }
}
