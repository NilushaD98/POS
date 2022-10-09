package com.example.newpos.posnew.service.impl;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateNSNByQueryRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateQueryRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import com.example.newpos.posnew.dto.response.CustomerEndpointIIResponseDTO;
import com.example.newpos.posnew.dto.response.ResponseActiveCustomerDTO;
import com.example.newpos.posnew.entity.Customer;
import com.example.newpos.posnew.repo.CustomerRepo;
import com.example.newpos.posnew.service.CustomerService;
import com.example.newpos.posnew.util.mappers.CustomerMapper;
import javassist.NotFoundException;
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

    @Autowired
    private CustomerMapper customerMapper;

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
            //CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);

            CustomerDTO customerDTO = customerMapper.entityToDTO(customer.get());
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

    @Override
    public boolean deleteCustomer(int id) throws NotFoundException {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new NotFoundException("not found exeption");
        }
        return true;
    }

    @Override
    public List<CustomerDTO> getCustomerByName(String customerName) throws NotFoundException {

        List<Customer> customers = customerRepo.findAllByCustomerNameEquals(customerName);
        if (customers.size() != 0) {
            List<CustomerDTO> customerDTOList = modelMapper
                    .map(customers, new TypeToken<List<CustomerDTO>>() {
                    }.getType());
            return customerDTOList;
        } else {
            throw new NotFoundException("No Results");
        }
    }

    @Override
    public List<CustomerDTO> getCustomerByActiveState() throws NotFoundException {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
        if (customers.size() != 0) {
            List<CustomerDTO> customerDTOList = customerMapper.entityListToDTOList(customers);
            return customerDTOList;
        } else {
            throw new NotFoundException("No Active Customer");
        }
    }

    @Override
    public List<ResponseActiveCustomerDTO> getCustomerByActiveStateOnlyName() throws NotFoundException {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
        if (customers.size() != 0) {
            List<ResponseActiveCustomerDTO> responseActiveCustomerDTOS = customerMapper.entityListToDTOListOnlyName(customers);
//            for (Customer c : customers) {
//                ResponseActiveCustomerDTO responseActiveCustomerDTO = new ResponseActiveCustomerDTO(
//                        c.getCustomerName(),
//                        c.getContacts()
//                );
            return responseActiveCustomerDTOS;
        } else {
            throw new NotFoundException("No Active Customer");
        }
    }
    @Override
    public String updateCustomerByQuery(CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO, int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.updateCustomerByQuery(customerUpdateQueryRequestDTO.getCustomerName(), customerUpdateQueryRequestDTO.getNic(), id);
            return customerUpdateQueryRequestDTO.getCustomerName() + " Updated";
        } else {
            return "not found customer";
        }

    }
    @Override
    public List<CustomerDTO> getCusomerByNIC(String nic) throws NotFoundException {
        List<Customer> customerList = customerRepo.findAllByNicEquals(nic);

        if (customerList.size() != 0) {
            List<CustomerDTO> customerDTOList = customerMapper.entityListToDTOList(customerList);
            return customerDTOList;
        } else {
            throw new NotFoundException("No any Customer to this nic number");
        }
    }
    @Override
    public CustomerEndpointIIResponseDTO getCustomerByIdOnlySallaryAndAddress(int id) throws NotFoundException {

        Optional<Customer> customer = customerRepo.findById(id);

        if (customer.isPresent()) {

            CustomerEndpointIIResponseDTO customerEndpointIIResponseDTO = customerMapper.entityToCustomerEndpointIIResponseDTO(customer.get());
            return customerEndpointIIResponseDTO;
        } else {
            throw new NotFoundException("this customer not here");
        }
    }
    @Override
    public String updateCustomerNSNByQuery(CustomerUpdateNSNByQueryRequestDTO customerUpdateNSNByQueryRequestDTO, int id) throws NotFoundException {

        if (customerRepo.existsById(id)) {
            customerRepo.updateCustomerNSNByQuery(customerUpdateNSNByQueryRequestDTO.getCustomerName(), customerUpdateNSNByQueryRequestDTO.getCustomerSalary(), customerUpdateNSNByQueryRequestDTO.getNic(), id);
            return "update Success.. " + id;
        } else {
            throw new NotFoundException("customer not here");
        }
    }

    @Override
    public String getCustomerInactiveOrActiveByid(int id) throws NotFoundException {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()){
            if(customer.get().isActiveState()==true){
                CustomerDTO customerDTO = customerMapper.entityToDTO(customer.get());
                return  customerDTO.toString();
            }else{
                return "this is inactive customer";
            }
        }else{
            throw new NotFoundException("customer not here");
        }
    }

    @Override
    public CustomerDTO getCustomerByIdAndState(int id, boolean state) {
            Optional<Customer> customer = customerRepo.findById(id);
            if (customer.isPresent()) {
                if(customer.get().isActiveState()==state){
                    CustomerDTO customerDTO = customerMapper.entityToDTO(customer.get());
                    return customerDTO;
                }else{
                    throw new com.example.newpos.posnew.exception.NotFoundException("this type customer not here");
                }
            }else{
                throw new com.example.newpos.posnew.exception.NotFoundException("Not found customer");

            }
    }
}


