package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.SubAccount;
import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import com.lemon.leacc.leacc1.RestRepo.SubAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/subAccount")
@RestController
public class SubAccountController {
    @Autowired
    private SubAccountRepo SubAccountRepo;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private SessionService sessionService;

    @GetMapping("/all")
    public List<SubAccount> allSubAccount(){
        return SubAccountRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<SubAccount> getSubAccount(@PathVariable int id){
        Optional<SubAccount> SubAccount = SubAccountRepo.findById(id);
        if (!SubAccount.isPresent()){
            throw  new NullPointerException("SubAccount Not Found");
        }
        return SubAccount;
    }

    @PostMapping("/add")
    public void addSubAccount(@RequestBody SubAccount subAccount){
        subAccount.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        subAccount.setAccount(accountRepo.getOne(subAccount.getAccount().getAccountId()));
        SubAccountRepo.save(subAccount);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void putSubAccount(@PathVariable int id, @RequestBody SubAccount putSubAccount){
        Optional<SubAccount> SubAccount = SubAccountRepo.findById(id);
        if (!SubAccount.isPresent()){
            throw new NullPointerException("SubAccount Not Found");
        }
        putSubAccount.setSubAccountId(id);
        SubAccountRepo.save(putSubAccount);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubAccount(@PathVariable int id){
        Optional<SubAccount> SubAccount = SubAccountRepo.findById(id);
        if (!SubAccount.isPresent()){
            throw new NullPointerException("SubAccount Not Found");
        }
        SubAccountRepo.deleteById(id);
    }
}
