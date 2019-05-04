package com.lemon.leacc.leacc1.RestController;


import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.RestRepo.FiscalAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/fiscalAccount")
@RestController
public class FiscalAccountController {
    @Autowired
    private FiscalAccountRepo fiscalAccountRepo;

    @GetMapping("/all")
    public List<FiscalAccount> allFiscalAccount(){
        return fiscalAccountRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<FiscalAccount> getFiscalAccount(@PathVariable int id){
        Optional<FiscalAccount> fiscalAccount = fiscalAccountRepo.findById(id);
        if (!fiscalAccount.isPresent()){
            throw  new NullPointerException("FiscalAccount Not Found");
        }
        return fiscalAccount;
    }

    @PostMapping("/addFiscalAccount")
    public void addFiscalAccount(@RequestBody FiscalAccount FiscalAccount){
        fiscalAccountRepo.save(FiscalAccount);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void putFiscalAccount(@PathVariable int id, @RequestBody FiscalAccount putFiscalAccount){
        Optional<FiscalAccount> fiscalAccount = fiscalAccountRepo.findById(id);
        if (!fiscalAccount.isPresent()){
            throw new NullPointerException("FiscalAccount Not Found");
        }
        putFiscalAccount.setFisacalAccountId(id);
        fiscalAccountRepo.save(putFiscalAccount);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFiscalAccount(@PathVariable int id){
        Optional<FiscalAccount> fiscalAccount = fiscalAccountRepo.findById(id);
        if (!fiscalAccount.isPresent()){
            throw new NullPointerException("FiscalAccount Not Found");
        }
        fiscalAccountRepo.deleteById(id);
    }
}
