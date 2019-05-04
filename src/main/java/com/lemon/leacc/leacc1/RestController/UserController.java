package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/addUser")
    public void addUser(@RequestBody Map<String, Object> payload){
        userService.save(payload);
    }




}
