package com.cibt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibt.models.Customer;
import com.cibt.repositories.CustomerRepository;


@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private CustomerRepository repository;
    
    @GetMapping
    public String index(ModelMap map){
        addCustomers();
        map.addAttribute("name", "Real Time Sales Tracker");
        return "public/home";
    }

    private void addCustomers(){
        repository.save(new Customer(0, "Ram Kumar", "lagenkhel", "87969876"));
        System.out.println("record added");
    }
}
