package com.example.newpos.posnew.Controller;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import com.example.newpos.posnew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/Customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path ="save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){

        String id = customerService.addCustomer(customerSaveRequestDTO);
        return id;
    }
    @PutMapping(path = "update")
    public String UpdateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
       String state =  customerService.updateCustomer(customerUpdateRequestDTO);
        System.out.println(customerUpdateRequestDTO.getCustomerName());
        System.out.println(customerUpdateRequestDTO.getCustomerID());
        System.out.println(customerUpdateRequestDTO.getCustomerAddress());
        System.out.println(customerUpdateRequestDTO.getCustomerSalary());
        System.out.println(customerUpdateRequestDTO.getContacts());
        System.out.println(customerUpdateRequestDTO.getNic());
        System.out.println(customerUpdateRequestDTO.isActiveState());
        return customerUpdateRequestDTO.getCustomerName();
    }
}