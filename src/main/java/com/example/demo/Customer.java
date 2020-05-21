package com.example.demo;

public class Customer {
    private String customerName;
    private String customerPhone;
    private Pet customerPet;

    public Customer(){
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Pet getCustomerPet() {
        return customerPet;
    }

    public void setCustomerPet(Pet customerPet) {
        this.customerPet = customerPet;
    }
}
