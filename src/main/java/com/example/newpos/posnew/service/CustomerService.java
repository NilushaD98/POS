package com.example.newpos.posnew.service;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {


    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws NotFoundException;

    List<CustomerDTO> getCustomerByName(String customerName) throws NotFoundException;
}
