package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/account")
@RestController
public class AccountController {

    @Autowired
    private AccountRepo accountRepo;


    @GetMapping("/all")
    public List<Account> allAccount(){
        return accountRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Account> getAccount(@PathVariable int id){
        Optional<Account> account = accountRepo.findById(id);
        if (!account.isPresent()){
            throw  new NullPointerException("Account Not Found");
        }
        return account;
    }

    @PostMapping("/addAccount")
    public void addAccount(@RequestBody Account account){
        accountRepo.save(account);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void putAccount(@PathVariable int id, @RequestBody Account putAccount){
        Optional<Account> account = accountRepo.findById(id);
        if (!account.isPresent()){
            throw new NullPointerException("Account Not Found");
        }
        putAccount.setAccountId(id);
        accountRepo.save(putAccount);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteAccount(@PathVariable int id){
        Optional<Account> account = accountRepo.findById(id);
        if (!account.isPresent()){
            throw new NullPointerException("Account Not Found");
        }
        accountRepo.deleteById(id);
    }
}
