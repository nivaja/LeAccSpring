package com.lemon.leacc.leacc1.ViewController;

import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.RestRepo.CustomerRepo;
import com.lemon.leacc.leacc1.viewModel.CustomerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class CustomerViewController {
    @Autowired
    private CustomerRepo customerRepo;

    @RequestMapping("/manage/customer/{id}")
    public String getCustomer(Model model, @PathVariable int id){
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()){
            model.addAttribute("customerView",new CustomerView(customer.get()));
            return "view/customer_view";
        }
            throw new RuntimeException("Customer Not Found");


    }
}
