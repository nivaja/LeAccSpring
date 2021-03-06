package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Sales;
import com.lemon.leacc.leacc1.Model.SalesAgent;
import com.lemon.leacc.leacc1.RestRepo.SalesAgentRepo;
import com.lemon.leacc.leacc1.RestRepo.SalesRepo;
import com.lemon.leacc.leacc1.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/api/sales")
public class SalesEntryController {

    @Autowired
    SalesRepo salesRepo;

    @Autowired
    SalesService salesService;
    @Autowired
    SessionService sessionService;

    @PostMapping("/add")
    public void addSalesAgent(@RequestBody Map<String, Object> json) throws ParseException,NullPointerException,NumberFormatException {
        salesService.save(json);
    }

    @GetMapping("/get/{id}")
    public Sales getById(@PathVariable int id){
        return salesRepo.getOne(id);
    }
}
