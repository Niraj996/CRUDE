package com.cibt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibt.models.Customer;
import com.cibt.repositories.CustomerRepository;


@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    
    @GetMapping
    public String index(ModelMap map){

        map.addAttribute("customers", repository.findAll());
        return "admin/customers/index";
    }

    @GetMapping(value = "/add")
    public String add(){
        return "admin/customers/add";
    }

     @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable(value = "id")int id,Model model){
        Customer customer=repository.findById(id).get();
        model.addAttribute("customer",customer);
        return "admin/customers/edit";
    }

    @PostMapping(value = "/save")
    public String save(Customer customer){
        repository.save(customer);
        return "redirect:/customers";
    }


    /*private void addCustomers(){
        repository.save(new Customer(0, "Ram Kumar", "lagenkhel", "87969876"));
        System.out.println("record added");
    }*/
}
