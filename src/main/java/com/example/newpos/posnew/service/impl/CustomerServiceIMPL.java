package com.example.newpos.posnew.service.impl;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import com.example.newpos.posnew.entity.Customer;
import com.example.newpos.posnew.repo.CustomerRepo;
import com.example.newpos.posnew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {

        Customer customer =new Customer(
                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getCustomerSalary(),
                customerSaveRequestDTO.getContacts(),
                customerSaveRequestDTO.getNic(),
                false
        );

        if(!customerRepo.existsById(customer.getCustomerID())){
            customerRepo.save(customer);
        }else{
            System.out.println("user already saved....");
        }

        return customer.getCustomerName()+ " Saved";
    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {

        if(customerRepo.existsById(customerUpdateRequestDTO.getCustomerID())){
            Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerID());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateRequestDTO.getCustomerSalary());
            customer.setContacts(customerUpdateRequestDTO.getContacts());
            customer.setNic(customerUpdateRequestDTO.getNic());

            customerRepo.save(customer);
        }
        return " null";
    }
}
