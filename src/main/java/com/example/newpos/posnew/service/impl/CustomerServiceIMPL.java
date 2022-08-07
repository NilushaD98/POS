package com.example.newpos.posnew.service.impl;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import com.example.newpos.posnew.entity.Customer;
import com.example.newpos.posnew.repo.CustomerRepo;
import com.example.newpos.posnew.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {

        Customer customer = new Customer(
                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getCustomerSalary(),
                customerSaveRequestDTO.getContacts(),
                customerSaveRequestDTO.getNic(),
                false
        );

        if (!customerRepo.existsById(customer.getCustomerID())) {
            customerRepo.save(customer);
        } else {
            System.out.println("user already saved....");
        }

        return customer.getCustomerName() + " Saved";
    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {

        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerID())) {
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

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.get().getCustomerID(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustomerAddress(),
//                    customer.get().getCustomerSalary(),
//                    customer.get().getContacts(),
//                    customer.get().getNic(),
//                    customer.get().isActiveState()
//            );
//
//            return  customerDTO;

            CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);
            return customerDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomer = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
//        for(Customer c:getCustomer){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    c.getCustomerID(),
//                    c.getCustomerName(),
//                    c.getCustomerAddress(),
//                    c.getCustomerSalary(),
//                    c.getContacts(),
//                    c.getNic(),
//                    c.isActiveState()
//            );

        List<CustomerDTO> customerDTOS = modelMapper
                .map(getCustomer, new TypeToken<List<CustomerDTO>>() {
                }.getType());

        return customerDTOS;


    }
}
