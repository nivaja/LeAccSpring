package com.lemon.leacc.leacc1.RestController;


import com.lemon.leacc.leacc1.Model.AccountGroup;
import com.lemon.leacc.leacc1.RestRepo.AccountGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/accountGroup")
@RestController
public class AccountGroupController {
    @Autowired
    private AccountGroupRepo accountGroupRepo;

    @GetMapping("/all")
    public List<AccountGroup> allAccountGroup(){
        return accountGroupRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<AccountGroup> getaccountGroup(@PathVariable int id){
        Optional<AccountGroup> accountGroup = accountGroupRepo.findById(id);
        if (!accountGroup.isPresent()){
            throw  new NullPointerException("accountGroup Not Found");
        }
        return accountGroup;
    }

    @PostMapping("/addaccountGroup")
    public void addAccountGroup(@RequestBody AccountGroup accountGroup){
        accountGroupRepo.save(accountGroup);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void putAccountGroup(@PathVariable int id, @RequestBody AccountGroup putaccountGroup){
        Optional<AccountGroup> accountGroup = accountGroupRepo.findById(id);
        if (!accountGroup.isPresent()){
            throw new NullPointerException("accountGroup Not Found");
        }
        putaccountGroup.setAccountGroupId(id);
        accountGroupRepo.save(putaccountGroup);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteAccountGroup(@PathVariable int id){
        Optional<AccountGroup> accountGroup = accountGroupRepo.findById(id);
        if (!accountGroup.isPresent()){
            throw new NullPointerException("accountGroup Not Found");
        }
        accountGroupRepo.deleteById(id);
    }
}
