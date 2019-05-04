package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.Company;
import com.lemon.leacc.leacc1.Auth.CompanyRepo;
import com.lemon.leacc.leacc1.Auth.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    SessionService sessionService;
    @GetMapping("/all")
    public List<Company> getAllCompany(){
        return companyRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Company> getAllCompany(@PathVariable int id){
        Optional<Company> company =companyRepo.findById(id);
        return company;
    }


    //@ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/addCompany")
    public String addCompany(@RequestBody Company company){

        companyRepo.save(company);
        return "Saved";
    }

    @GetMapping("/get")
    public Company getCompany(){
        return companyRepo.getOne(sessionService.getCurrentUserSession().getCompany().getCompanyId());
    }

    @PutMapping("/put")
    public String updateCompany(@RequestBody Company company){
        company.setCompanyId(sessionService.getCurrentUserSession().getCompany().getCompanyId());
        companyRepo.save(company);
        return "updated";
    }
}
