package com.lemon.leacc.leacc1.WebController;

import com.lemon.leacc.leacc1.Auth.*;
import com.lemon.leacc.leacc1.BussinessLogic.Dashboard;
import com.lemon.leacc.leacc1.BussinessLogic.ProfitAndLoss;
import com.lemon.leacc.leacc1.BussinessLogic.StockLedger;
import com.lemon.leacc.leacc1.Model.*;
import com.lemon.leacc.leacc1.RestRepo.*;
import com.lemon.leacc.leacc1.service.CompanyService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class IndexController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    CompanyService companyService;

    @Autowired
    SessionService sessionService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PreAuthorize("hasAnyRole('SALES','COMPANY','ADMIN')")
    @RequestMapping("/dashboard")
    public String dashboard(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal authUser = (UserPrincipal) auth.getPrincipal();
        Optional<User> optionalUser = userRepo.findByUsername(authUser.getUsername());
        if (!optionalUser.isPresent()){
            throw  new RuntimeException("USER NOT FOUND");
        }
        User user=  optionalUser.get();
        model.addAttribute("dashboard",new Dashboard(sessionService.getCurrentUserSession().getFiscalAccount()));
        System.out.println(user.getUsername()+", "+user.getCompany().getCompanyId());
        return "dashboard";
    }

    @GetMapping("/register")
    public String registerCompany(){
        return "register";
    }

    @PostMapping(value = "/register")
    public String registerCompany(@RequestParam Map<String,String> params){
   System.out.println(params.size()+" "+ params.get("companyName"));
        companyService.registerCompany(
        new Company(params.get("name"),params.get("phone"),params.get("email"),params.get("password"),params.get("companyInitial"))
         );
        return "login";
    }

    @Autowired
    AccountTypeRepo accountTypeRepo;
    @Autowired
    AccountRepo accountRepo;

    @GetMapping("/coa")
    public String coa(Model model){
       // model.addAttribute("accountTypeGroups",accountTypeGroupRepo.findAll());
        model.addAttribute("accountTypes",accountTypeRepo.findAll());
        model.addAttribute("accounts",accountRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount()));

        return "chartOfAccount";
    }


    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    SalesAgentRepo salesAgentRepo;
    @Autowired
    VehicleRepo vehicleRepo;
    @RequestMapping("/sales/invoice")
    public String salesInvoice(Model model){
        List<SalesAgent> salesAgents = salesAgentRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<Vehicle> vehicles = vehicleRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<Customer> customers =customerRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<Product> products =productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<SubAccount> cashSubAccounts = subAccountRepo.findByAccount_AccountDescription("cash");
        model.addAttribute("products",products);
        model.addAttribute("vehicles",vehicles);
        model.addAttribute("sales_agents",salesAgents);
        model.addAttribute("customers",customers);
        model.addAttribute("cashSubAccounts",cashSubAccounts);

        return "sales_entry";
    }

    @Autowired
    VendorRepo vendorRepo;
    @RequestMapping("/purchase/bill")
    public String purchaseBill(Model model){
        List<Vehicle> vehicles = vehicleRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<Vendor> vendors =vendorRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<Product> products =productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        model.addAttribute("products",products);
        model.addAttribute("vehicles",vehicles);
        model.addAttribute("vendors",vendors);

        return "purchase_entry";
    }

    @Autowired
    SubAccountRepo subAccountRepo;
    @RequestMapping("/voucher/payment")
    public String voucherPayment(Model model){
        FiscalAccount fiscalAccount =sessionService.getCurrentUserSession().getFiscalAccount();
        List<Account> accounts = accountRepo.findByFiscalAccount(fiscalAccount);
        List<SubAccount> cashSubAccounts = subAccountRepo.findByAccount_AccountDescription("cash");
        List<SubAccount> subAccounts = subAccountRepo.findByFiscalAccount(fiscalAccount);

        model.addAttribute("subAccounts",subAccounts);
        model.addAttribute("cashSubAccounts",cashSubAccounts);
        model.addAttribute("accounts",accounts);
        return "voucher_payment_entry";
    }

    @RequestMapping("/voucher/reciept")
    public String voucherReciept(Model model){

        FiscalAccount fiscalAccount =sessionService.getCurrentUserSession().getFiscalAccount();
        List<Account> accounts = accountRepo.findByFiscalAccount(fiscalAccount);
        List<SubAccount> cashSubAccounts = subAccountRepo.findByAccount_AccountDescription("cash");
        List<SubAccount> subAccounts = subAccountRepo.findByFiscalAccount(fiscalAccount);

        model.addAttribute("subAccounts",subAccounts);
        model.addAttribute("cashSubAccounts",cashSubAccounts);
        model.addAttribute("accounts",accounts);
        return "voucher_reciept_entry";
    }

    @RequestMapping("/journal/entry")
    public String journalEntry(Model model) {
        FiscalAccount fiscalAccount =sessionService.getCurrentUserSession().getFiscalAccount();
        List<Account> accounts = accountRepo.findByFiscalAccount(fiscalAccount);
        List<SubAccount> subAccounts = subAccountRepo.findByFiscalAccount(fiscalAccount);

        model.addAttribute("subAccounts",subAccounts);
        model.addAttribute("accounts",accounts);
        return "journal_entry";
    }
    @RequestMapping("/vehicle/fuel")
    public String vehicleFuel(Model model){
        List<Vehicle> vehicles = vehicleRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        model.addAttribute("vehicles",vehicles);
        return "fuel_entry";
    }

    @RequestMapping("/vehicle/maintenance")
    public String vehicleMaintenance(Model model){
        List<Vehicle> vehicles = vehicleRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        model.addAttribute("vehicles",vehicles);
        return "maintenance_entry";
    }

    @RequestMapping("/vehicle/part")
    public String vehiclePart(){
        return "vehicle_part_entry";
    }

    @Autowired
    GodownRepo godownRepo;
    @RequestMapping("/inventory/transfer")
    public String inventoryTransfer(Model model){
        List<Product> products =productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<Godown> godowns =godownRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        model.addAttribute("products",products);
        model.addAttribute("godowns",godowns) ;
        return "inventory_transfer_entry";
    }

    @RequestMapping("/production/finished_good_entry")
    public String finishedGoodEntry(Model model){
        List<Product> products =productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        List<Godown> godowns =godownRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        model.addAttribute("products",products);
        model.addAttribute("godowns",godowns) ;
        return "finished_good_entry";
    }
    @RequestMapping("report/profitAndLoss")
    public String profitAndLoss(Model model)
    {
        model.addAttribute("profitAndLoss",new ProfitAndLoss(sessionService.getCurrentUserSession().getFiscalAccount()));
        return "profit_and_loss_report";
    }

    @RequestMapping("/setting/company_date_setting")
    public String companyDateSetting(){
        return "company_date_setting";
    }
////
    @RequestMapping("/manage/user")
    public String user(Model model){
        model.addAttribute("actions",new String[] {"VIEW","EDIT","CREATE","DELETE","REPORT"});
        model.addAttribute("roles",new String[] {"SALES", "Purchase", "Reciept", "payment", "fuel_entry", "maintenance_entry", "part_entry", "inventory_transfer", "Finished_good_entry", "chart_of_account", "company", "customer", "user", "vendor", "employee", "transportation", "product", "finished_product_map"});
        return "user";
    }

    @RequestMapping("/manage/customer")
    public String customer(Model model){
        model.addAttribute("customers",customerRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount()));
        model.addAttribute("");
        return "customer";
    }
    @RequestMapping("/manage/vendor")
    public String vendor(){
        return "vendor";
    }
    @RequestMapping("/manage/transportation")
    public String trasportation(){
        return "transportation";
    }
    @RequestMapping("/manage/employee")
    public String employee(){
        return "employee";
    }

    @RequestMapping("/manage/sales_agent")
    public String SalesAgent(){
        return "sales_agent";
    }

    @RequestMapping("/manage/godown")
    public String godown(){
        return "godown";
    }

    @RequestMapping("/manage/product")
    public String product(){
        return "product";
    }

    @RequestMapping("/manage/finished_product_map")
    public String finishedProductMap(Model model){
        List<Product> products =productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        model.addAttribute("products",products);
        return "finished_product_map";
    }

    @Autowired
    StockLedger stockLedger;
    @RequestMapping("/reports/stockLedger/{id}")
    public String stockLedger(Model model, @PathVariable int id){
        model.addAttribute("stockItems",stockLedger.generateStockLedgerByProduct(productRepo.getOne(id)));

        return "stock_ledger";
    }





    @RequestMapping("/logout")
    public String logout(){
        return "login";
    }
}
