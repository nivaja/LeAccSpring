package com.lemon.leacc.leacc1.ViewController;

import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CashBookController {
    @Autowired
    AccountRepo accountRepo;


}
