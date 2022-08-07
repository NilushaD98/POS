package com.example.newpos.posnew.Controller;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import com.example.newpos.posnew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return customerUpdateRequestDTO.getCustomerName();
    }

    @GetMapping(
            path = "get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam (value = "id") int id){

        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return  customerDTO;
    }

    @GetMapping (
            path = "get-all-customwe"
    )
    public List<CustomerDTO> getAllCustomer(){

        List<CustomerDTO>allCustomers = customerService.getAllCustomers();
        return allCustomers;

    }
}