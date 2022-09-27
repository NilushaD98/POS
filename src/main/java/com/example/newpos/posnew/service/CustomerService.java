package com.example.newpos.posnew.service;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateNSNByQueryRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateQueryRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import com.example.newpos.posnew.dto.response.CustomerEndpointIIResponseDTO;
import com.example.newpos.posnew.dto.response.ResponseActiveCustomerDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {


    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws NotFoundException;

    List<CustomerDTO> getCustomerByName(String customerName) throws NotFoundException;

    List<CustomerDTO> getCustomerByActiveState() throws NotFoundException;


    List<ResponseActiveCustomerDTO> getCustomerByActiveStateOnlyName() throws NotFoundException;

    String updateCustomerByQuery(CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO, int id);

    List<CustomerDTO> getCusomerByNIC(String nic) throws NotFoundException;

    CustomerEndpointIIResponseDTO getCustomerByIdOnlySallaryAndAddress(int id) throws NotFoundException;

    String updateCustomerNSNByQuery(CustomerUpdateNSNByQueryRequestDTO customerUpdateNSNByQueryRequestDTO, int id) throws NotFoundException;

    String getCustomerInactiveOrActiveByid(int id) throws NotFoundException;

    CustomerDTO getCustomerByIdAndState(int id, boolean state);

}
