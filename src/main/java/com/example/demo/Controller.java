package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Customer> catCustomers = new ArrayList<>();
    ArrayList<Customer> dogCustomers = new ArrayList<>();

    @RequestMapping("/home")
    public String homePage(Model model){
        model.addAttribute("customerList", customers);
        return "customerList";
    }

    @GetMapping("/newCustomer")
    public String customerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "newCustomerForm";
    }

    @PostMapping("/customerList")
    public String displayCustomer(@ModelAttribute Customer customer, Pet pet){
        customer.setCustomerPet(pet);
        if(pet.getPetType().equalsIgnoreCase("dog")){
            dogCustomers.add(customer);
        }else {
            catCustomers.add(customer);
        }
        customers.add(customer);
        return "redirect:/home";
    }

    @PostMapping("/check")
    public String dogOrCat(@RequestParam("petType") String petType, @RequestParam("customerName") String customerName,
                           @RequestParam("customerPhone") String customerPhone, Customer customer, Model model){
        Pet newPet = new Pet();
        newPet.setPetType(petType);
        customer.setCustomerName(customerName);
        customer.setCustomerPhone(customerPhone);
        if(petType.equalsIgnoreCase("dog")){
            model.addAttribute("newDog", newPet);
            return"dogForm";
        }
        else if (petType.equalsIgnoreCase("cat")){
            model.addAttribute("newCat", newPet);
            return "catForm";
        }
        return "redirect:/newCustomer";
    }

    @GetMapping("/dogList")
    public String listOfDogs(Model model){
        model.addAttribute("dogList", dogCustomers);
        return "dogList";
    }
    @GetMapping("/catList")
    public String listOfCats(Model model){
        model.addAttribute("catList", catCustomers);
        return "catList";
    }


}
